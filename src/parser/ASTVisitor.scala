package parser
import scala.jdk.CollectionConverters.*
import ast.{AST, Op, Term}
import Term.{Let, Lit, BOp, IfZ, Var, Fun, Fix, App}
import parser.PCFParser

import java.util

class ASTVisitor[AST] extends PCFBaseVisitor[AST] :
  override def visitLit(ctx: PCFParser.LitContext): AST =
    Lit(ctx.getText.toInt).asInstanceOf[AST]

  override def visitBOp(ctx: PCFParser.BOpContext): AST =
    val op = Op.parse(ctx.OP.getText)
    val ANTLRTerms = ctx.term.asScala.toList
    val List(term1, term2) =
      for (ANTLRTerm <- ANTLRTerms) yield
        visit(ANTLRTerm).asInstanceOf[Term]
    BOp(op, term1, term2).asInstanceOf[AST]

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
    val varName = ctx.VAR.getText
    val ANTLRTerms = ctx.term.asScala.toList
    val List(term1, term2) =
      for(ANTLRTerm <- ANTLRTerms) yield
        visit(ANTLRTerm).asInstanceOf[Term]
    Let(varName, term1, term2).asInstanceOf[AST]
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

  override def visitFix(ctx: PCFParser.FixContext): AST = {
    val x = ctx.VAR.getText
    val term = visit(ctx.term).asInstanceOf[Term]
    Fix(x, term).asInstanceOf[AST]
  }

