package gen

import ast.ATerm
import ast.ATerm.{BOp, IfZ, Lit}
import ast.Op.{DIVIDE, MINUS, PLUS, TIMES}

enum Code {
  case Ins(ins: String)
  case Seq(seq: List[Code])
  case Test(isZero: Code, ThenTerm: Code, ElseTerm: Code)
}

object Gen {
  val empty: List[Code] = Nil

  def gen(t: ATerm): String = {
    println(t)
    "(module\n" +
      s"${format(1, declare.all())}" +
      "  (func (export \"main\") (result i32)\n" +
      s"${format(2, emit(t))}" +
      "  return))\n"
  }

  private def emit(t: ATerm): Code = {
    t match
      case Lit(n) => Code.Ins(s"i32.const $n") //Si n est un Int
      case BOp(op, t1, t2) =>
        val instruction = op match
          case PLUS => "i32.add"
          case MINUS => "i32.sub"
          case TIMES => "i32.mul"
          case DIVIDE => "i32.div_u"
        Code.Seq(List(
          emit(t1),
          emit(t2),
          Code.Ins(instruction)
        ))
      case IfZ(isZero, thenTerm, elseTerm) =>
        Code.Test(emit(isZero), emit(thenTerm), emit(elseTerm))
      case _ => ??? //TODO
  }

  private def spaces(depth: Int): String = (for i <- 0 until depth yield "  ").mkString

  private def format(d: Int, code: Code): String = code match
    case Code.Ins(s) => s"${spaces(d)}$s\n"
    case Code.Seq(l) =>
      (for (code <- l) yield format(d, code)).mkString
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
    case _ => ??? //TODO
}