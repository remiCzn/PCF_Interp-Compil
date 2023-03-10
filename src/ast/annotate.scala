package ast

import ast.Term
import interp.Interp.Env

type ATerm = Term
type Env = List[String]

def annotate(term: Term, e: Env) : ATerm = term
