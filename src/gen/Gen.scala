package gen

import ast.ATerm
import ast.Op.{DIVIDE, MINUS, PLUS, TIMES}
import ast.Term.{BOp, Lit}

enum Code {
  case Ins(ins: String)
  case Seq(seq: List[Code])
  case Test(code1: Code, code2: Code)
}

object Gen {
  val empty: List[Code] = Nil

  def gen(t: ATerm): String = {
    "(module\n" +
    "  (func (export \"main\") (result i32)\n" +
    s"${format(2, emit(t))}" +
    "  return))\n"
  }

  private def emit(t: ATerm): Code = {
    t match
      case Lit(n) => Code.Ins(s"i32.const $n")
      case BOp(op, t1, t2) => {
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
      }
      case _ => ???
  }

  private def spaces(depth: Int): String = (for i <- 0 until depth yield "  ").mkString
  private def format(d: Int, code: Code): String = code match
    case Code.Ins(s) => s"${spaces(d)}$s\n"
    case Code.Seq(l) => {
      (for(code <- l) yield format(d,code)).mkString
    }
    case _ => ???
}