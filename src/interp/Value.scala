package interp

import ast.Term
import interp.Interp.Env
import interp.Value.Closure

enum Value {
  case IntVal(i: Int)
  case Closure(x: String, t: Term, e: Env)

  override def toString: String = {
    this match
      case IntVal(i) => s"$i"
      case Closure(x, t, e) => s"$x -> $t"
  }
}

class IceCube(val t: Term, val e: Env)

def UnBoxValue(v: Value | IceCube): Value = {
  v.asInstanceOf[Value]
}

def BoxInt(i: Int): Value = {
  Value.IntVal(i)
}

def UnboxInt(i: Value): Int = {
  i match
    case Value.IntVal(x) => x
    case Value.Closure(_,_,_) => throw new WrongConversionException()
}