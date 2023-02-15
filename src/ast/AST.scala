package ast

trait AST

import ast.Op.{DIVIDE, MINUS, PLUS, TIMES}
import interp.Interp.Env
import interp.Value

enum Term extends AST :
  case Lit(n: Value)
  case BOp(op: Op, t1: Term, t2: Term)
  case IfZ(t1: Term, t2: Term, t3: Term)
  case Var(x: String)
  case Let(x: String, t1: Term, t2: Term)
  case App(t1: Term, t2: Term)
  case Fun(x: String, t1: Term)
  case Fix(x: String, t1: Term)

enum Op :
  case PLUS, MINUS, TIMES, DIVIDE

object Op :
  def parse(s: String): Op = s match
  case "+" => PLUS
  case "-" => MINUS
  case "*" => TIMES
  case "/" => DIVIDE
  case _ => ??? // should never happen

  
