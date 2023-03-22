package ast

import ast.Term
import interp.Interp.Env
import interp.Value

//type ATerm = Term
type Env = List[String]

enum ATerm:
  case Lit(n: Value)
  case BOp(op: Op, t1: ATerm, t2: ATerm)
  case IfZ(t1: ATerm, t2: ATerm, t3: ATerm)
  case Let(x: String, t1: ATerm, t2: ATerm)
  case Fun(variable: String, t1: ATerm)
  case App(t1: ATerm, t2: ATerm)
  case FixFun(f: String, x: String, t1: ATerm)
  case Var(s: String, index: Int)

def annotate(term: Term, e: Env): ATerm =
  term match
    case Term.Var(s) => ATerm.Var(s, e.indexOf(s))
    case Term.Lit(n) => ATerm.Lit(n)
    case Term.BOp(op, t1, t2) => ATerm.BOp(op, annotate(t1,e), annotate(t2,e))
    case Term.IfZ(t1, t2, t3) => ATerm.IfZ(annotate(t1, e), annotate(t2, e), annotate(t3, e))
    case Term.Let(x, t1, t2) => ATerm.Let(x, annotate(t1, e), annotate(t2, x :: e))
    case Term.Fun(varia, t1) => ATerm.Fun(varia, annotate(t1, varia :: e))
    case Term.App(t1, t2) => ATerm.App( annotate(t1, e), annotate(t2, e))
    case Term.FixFun(f, x, t1) => ATerm.FixFun(f, x, annotate(t1, e))
