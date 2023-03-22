package parser
import scala.jdk.CollectionConverters.*
import ast.{AST, Op, Term}
import Term.{App, BOp, FixFun, Fun, IfZ, Let, LetPlus, Lit, Var}
import interp.{BoxInt, Interp}
import parser.PCFParser
import interp.Value.*

import java.util

class ASTVisitor[AST] extends PCFBaseVisitor[AST] :
  override def visitLit(ctx: PCFParser.LitContext): AST =
    Lit(BoxInt(ctx.getText.toInt)).asInstanceOf[AST]

  override def visitBOp(ctx: PCFParser.BOpContext): AST =
    val op = if (ctx.OP1() != null) ctx.OP1() else ctx.OP2()
    val opSymbole = Op.parse(op.getText)
    val ANTLRTerms = ctx.term.asScala.toList
    val List(term1, term2) =
      for (ANTLRTerm <- ANTLRTerms) yield
        visit(ANTLRTerm).asInstanceOf[Term]
    BOp(opSymbole, term1, term2).asInstanceOf[AST]

  override def visitIfZ(ctx: PCFParser.IfZContext): AST =
    val ANTLRTerms = ctx.term.asScala.toList
    val List(term1, term2, term3) =
      for(ANTLRTerm <- ANTLRTerms) yield
        visit(ANTLRTerm).asInstanceOf[Term]

    IfZ(term1, term2, term3).asInstanceOf[AST]

  override def visitVar(ctx: PCFParser.VarContext): AST = {
    Var(ctx.getText).asInstanceOf[AST]
  }

  override def visitLet(ctx: PCFParser.LetContext): AST = {
    def getValues(value: PCFParser.AssignContext) : List[(String, Term)] = {
      if(value.VAR == null) {
        getValues(value.assign(0)) ++ getValues(value.assign(1))
      } else {
        val varName = value.VAR.getText
        val varValue = visit(value.term).asInstanceOf[Term]
        List((varName, varValue))
      }
    }

    val vars = getValues(ctx.assign)

    val expr = visit(ctx.term).asInstanceOf[Term]
    LetPlus(vars, expr).asInstanceOf[AST]
  }

  override def visitApp(ctx: PCFParser.AppContext): AST = {
    val List(term1, term2) =
      for(ANTLRTerm <- ctx.term.asScala.toList) yield
        visit(ANTLRTerm).asInstanceOf[Term]
    App(term1, term2).asInstanceOf[AST]
  }

  override def visitFun(ctx: PCFParser.FunContext): AST = {
    val x = ctx.VAR.getText
    val term = visit(ctx.term).asInstanceOf[Term]
    Fun(x, term).asInstanceOf[AST]
  }

  override def visitFixfun(ctx: PCFParser.FixfunContext): AST = {
    val List(f, n) = for (t <- ctx.VAR.asScala.toList) yield
      t.toString
    val term = visit(ctx.term).asInstanceOf[Term]
    FixFun(f, n, term).asInstanceOf[AST]
  }

  override def visitPar(ctx: PCFParser.ParContext): AST = {
    visit(ctx.term)
  }

