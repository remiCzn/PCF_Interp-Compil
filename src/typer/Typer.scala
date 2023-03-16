package typer

import ast.Term
import typer.Type

class TypeErrorException(message: String) extends Exception(message) {}

object Typer {
  def typer(term: Term, type_env: Map[String, Type]): Type = {
    term match
      case Term.Lit(_) => INT
      case Term.BOp(_, v1, v2) =>
        val t1 = typer(v1, type_env)
        val t2 = typer(v2, type_env)
        if (!(t1 === INT) || !(t2 === INT)) {
          throw new TypeErrorException(s"$v1 est du type $t1 mais $v2 est du type $t2")
        }
        t1
      case Term.IfZ(t1, t2, t3) =>
        if (!(typer(t1, type_env) === INT)) {
          throw new TypeErrorException(s"$t1 n'est pas un $INT")
        }
        val type2 = typer(t2, type_env)
        val type3 = typer(t3, type_env)
        if (!(type2 === type3)) {
          throw new TypeErrorException(s"$t2 est du type $type2 mais $t3 est du type $type3")
        }
        type2

      case Term.Var(x) => type_env.get(x) match
        case Some(value) => value
        case None => throw new TypeErrorException(s"$x n'a pas de type défini")
      case Term.Let(x, t1, t2) => typer(t2, type_env + (x -> typer(t1, type_env)))
      case Term.App(t1, t2) =>
        val type1 = typer(t1, type_env)
        val type2 = typer(t2, type_env)
        type1 match
          case a --> b => if (a === type2) b else throw new TypeErrorException(s"Le terme $t2 est du type $type2 mais devrait être du type $type1")
          case _: TVar => type2
          case _ => ???
      case Term.Fun(x, t1) =>
        val type_x = TVar()
        type_x --> typer(t1, type_env + (x -> type_x))
      case Term.Fix(x, t1) => typer(t1, type_env + (x -> TVar()))
  }
}
