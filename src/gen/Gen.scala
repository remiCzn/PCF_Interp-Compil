package gen

import ast.ATerm

enum Code {
  case Ins(ins: String)
  case Seq(seq: List[Code])
  case Test(code1: Code, code2: Code)
}

object Gen {
  val empty: List[Code] = Nil

  def gen(t: ATerm): String = Seq(List()).toString
}