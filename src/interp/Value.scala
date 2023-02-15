package interp

import ast.Term
import interp.Interp.Env

enum Value {
  case IntVal(i: Int)
  case Closure(x: String, t: Term, e: Env)
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