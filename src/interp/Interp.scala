package interp

import ast.{Op, Term}
import Term.*
import ast.Op.*
import interp.InterpretationException
import interp.Value.IntVal

import scala.Some
import scala.language.implicitConversions

object Interp :
  type Env = Map[String, Value | IceCube]

  def interp(t: Term, e: Env): Value = {
    t match
      case Lit(value) => value
      case BOp(op: Op, t1: Term, t2: Term) =>
        val v1 = UnboxInt(interp(t1, e))
        val v2 = UnboxInt(interp(t2, e))
        val res = op match
          case PLUS => v1 + v2
          case MINUS => v1 - v2
          case TIMES => v1 * v2
          case DIVIDE => v1 / v2
        BoxInt(res)
      case IfZ(t1: Term, t2: Term, t3: Term) =>
        val v1 = UnboxInt(interp(t1, e))
        if (v1 == 0) interp(t2, e) else interp(t3,e)
      case Var(x) =>
        e.get(x) match
          case Some(value: Value) => UnBoxValue(value)
          case Some(iceCube: IceCube) => interp(iceCube.t, e.concat(iceCube.e))
          case None => throw new InterpretationException(x)
      case Let(x, t1, t2) =>
        interp(t2, e + (x -> interp(t1, e)))
      case Fun(x: String, t: Term) =>
        Value.Closure(x, t, e)
      case App(t1: Term, t2: Term) =>
        val v1: Value.Closure = interp(t1, e).asInstanceOf[Value.Closure]
        val env = e.concat(v1.e)
        interp(v1.t, env + (v1.x -> interp(t2, env)))
      case Fix(x: String, t1: Term) =>
        interp(t1, e + (x -> IceCube(t1, e)))
  }





