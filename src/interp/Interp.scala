package interp

import ast.{Op, Term}
import Term.*
import ast.Op.*
import interp.InterpretationException

import scala.Some

object Interp :
  type Env = Map[String, Int]

  def interp(t: Term, e: Env): Int = {
    t match
      case Lit(value) => value
      case BOp(op: Op, t1: Term, t2: Term) =>
        val v1 = interp(t1, e)
        val v2 = interp(t2, e)
        op match
          case PLUS => v1 + v2
          case MINUS => v1 - v2
          case TIMES => v1 * v2
          case DIVIDE => v1 / v2
      case IfZ(t1: Term, t2: Term, t3: Term) =>
        val v1 = interp(t1, e)
        val v2 = interp(t2, e)
        val v3 = interp(t3, e)
        if (v1 == 0) v2 else v3
      case Var(x) =>
        e.get(x) match
          case Some(value) => value
          case None => throw new InterpretationException()
      case Let(x, t1, t2) =>
        interp(t2, e + (x -> interp(t1, e)))
  }





