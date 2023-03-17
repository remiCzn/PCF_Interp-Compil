package pcf

import ast.{AST, Term, transform}
import interp.{IceCube, Value}
import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream}
import parser.{ASTVisitor, Error, ErrorListener, PCFParser, ReportingPCFLexer, SyntaxError}
import typer.Type

import java.io.{FileInputStream, FileWriter, InputStream}

object Interp:
  def main(args: Array[String]): Unit =
    val (is, filename) =
      if args.length == 0
      then (System.in, None)
      else (new FileInputStream(args(0)), Some(args(0)))
    val verbose = args.length == 0 || args.length > 1 && args(1) == "-v"
    println(s"==> ${interpret()}")

    def analyze(): (Term, Type) =
      val input = new ANTLRInputStream(is)
      // val lexer = new CalcLexer(input)
      val lexer = new ReportingPCFLexer(input)
      val tokens = new CommonTokenStream(lexer)
      val parser = new PCFParser(tokens)
      parser.removeErrorListeners()
      parser.addErrorListener(new ErrorListener())
      val tree = parser.term()
      if (verbose) println(s"ANTLR Parse Tree: ${tree.toStringTree(parser)}")
      if !Error.flag then
        val visitor = new ASTVisitor
        val term = visitor.visit(tree).asInstanceOf[Term]
        val transformedTerm = transform(term).asInstanceOf[Term]
        if (verbose) println(s"AST: $transformedTerm")
        val typ = typer.Typer.typer(transformedTerm, Map())
        (transformedTerm, typ)
      else throw new SyntaxError(Error.msg)

    def interpret(): String =
      val (term, typ) = analyze()
      val value = interp.Interp.interp(term, Map())
      s"$value:$typ"
