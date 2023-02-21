package ast

trait AST

import ast.Op.{DIVIDE, MINUS, PLUS, TIMES}
import ast.Term.{IfZ, Lit}
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

  override def toString: String = {
    this match
      case Lit(n) => n.toString
      case BOp(op, t1, t2) => s"$t1 $op $t2"
      case IfZ(t1, t2, t3) => s"if($t1 == 0) { $t2 } else { $t3 }"
      case Var(x) => s"$x"
      case Let(x, t1, t2) => s"let $x = $t1 in ($t2)"
      case App(t1, t2) => s"$t1($t2)"
      case Fun(x, t1) => s"[$x -> $t1]"
      case Fix(x, t1) => s"Fix($x, $t1)"
  }

enum Op :
  case PLUS, MINUS, TIMES, DIVIDE

  override def toString: String = {
    this match
      case PLUS => "+"
      case MINUS => "-"
      case TIMES => "*"
      case DIVIDE => "/"
  }

object Op :
  def parse(s: String): Op = s match
  case "+" => PLUS
  case "-" => MINUS
  case "*" => TIMES
  case "/" => DIVIDE
  case _ => ??? // should never happen

  
