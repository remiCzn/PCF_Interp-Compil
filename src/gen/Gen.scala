package gen

import ast.ATerm
import ast.ATerm.{BOp, IfZ, Lit, Let, Var, Fun, App}
import ast.Op.{DIVIDE, MINUS, PLUS, TIMES}

enum Code {
  case Ins(ins: String)
  case Seq(seq: List[Code])
  case Test(isZero: Code, ThenTerm: Code, ElseTerm: Code)
}

object Gen {
  private var idx = 0
  private var bodies : List[Code] = Nil

  def gen(t: ATerm): String = {
    println(t)
    val body = emit(t)
    val table = emitTable
    val functions = emitFunctions

    "(module\n" +
      s"${format(0, declare.all())}" +
      s"\n" +
      s"${format(0, table)}" +
      s"\n" +
      s"${format(-1, functions)}" +
      s"\n" +
      "  (func (export \"main\") (result i32)\n" +
      s"${format(1, body)}" +
      "  return))\n"
  }

  private def emitTable: Code =
    var table_ = List[Code]()
    table_ = table_ :+ Code.Ins("(table funcref")
    table_ = table_ :+ Code.Ins("  (elem")
    for (i <- 0 until idx) {
      table_ = table_ :+ Code.Ins("    $closure" + i.toString)
    }
    table_ = table_ :+ Code.Ins("  )")
    table_ = table_ :+ Code.Ins(")")
    Code.Seq(table_)

  private def emitFunction(i: Int, body: Code): Code =
    Code.Seq(List(
      Code.Ins("(func " + "$closure" +i.toString + " (result i32)"),
      //PushEnv,
      //Code.Ins("(local.get $x)"),
      //Extend,
      Code.Seq(List(body)),
      //SaveAcc,
      //PopEnv,
      //RetrieveAcc,
      Code.Ins("  (return)"),
      Code.Ins(")")
      )
    )

  private def emitFunctions: Code =
    var codeList : List[Code] = List()
    ///bodies = bodies.reverse
    for (i <- 0 until idx) {
      codeList = emitFunction(i, bodies(i)) :: codeList
    }
    Code.Seq(codeList)

  private def emit(t: ATerm): Code = t match
    case Lit(n) => Code.Ins(s"(i32.const $n)") //Si n est un Int
    case BOp(op, t1, t2) =>
      val instruction = op match
        case PLUS => "(i32.add)"
        case MINUS => "(i32.sub)"
        case TIMES => "(i32.mul)"
        case DIVIDE => "(i32.div_u)"
      Code.Seq(List(
        emit(t1),
        emit(t2),
        Code.Ins(instruction)
      ))
    case IfZ(isZero, thenTerm, elseTerm) =>
      Code.Test(emit(isZero), emit(thenTerm), emit(elseTerm))
    case Let(_, t, u) =>
      Code.Seq(List(
        PushEnv,
        emit(t),
        Extend,
        emit(u),
        SaveAcc,
        PopEnv,
        RetrieveAcc
      ))
    case Var(_, idx) =>
      Search(idx, Code.Ins("(global.get $ENV)"))
    case Fun(_, t1) =>
      val closure = MkClos(idx)
      idx +=1
      bodies = emit(t1) :: bodies
      //bodies = (emit(t1) :: bodies.reverse).reverse
      println(bodies)
      closure
    case App(func: ATerm, arg: ATerm) =>
      Apply(emit(func), emit(arg))

  private def spaces(depth: Int): String = (for _ <- 0 until depth yield "  ").mkString

  private def format(d: Int, code: Code): String = code match
    case Code.Ins(s) => s"${spaces(d)}$s\n"
    case Code.Seq(l) =>
      (for (code <- l) yield format(d+1, code)).mkString
    case Code.Test(isZero, thenTerm, elseTerm) =>
      format(d, isZero) +
        s"${spaces(d)}(if (result i32)\n" +
        s"${spaces(d + 1)}(then\n" +
        format(d + 2, elseTerm) +
        s"${spaces(d + 1)})\n" +
        s"${spaces(d + 1)}(else\n" +
        format(d + 2, thenTerm) +
        s"${spaces(d + 1)})\n" +
        s"${spaces(d)})\n"
}