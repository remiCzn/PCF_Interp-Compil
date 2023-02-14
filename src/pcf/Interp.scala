package pcf

import java.io.{FileInputStream, InputStream}
import ast.Term
import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream}
import parser.{ReportingPCFLexer, PCFParser, ErrorListener, Error, SyntaxError, ASTVisitor}
import interp.Interp.interp

object Interp :
  def main(args: Array[String]): Unit =
    val is = if (args.length == 0) System.in else new FileInputStream(args(0))
    val verbose = args.length == 0 || args.length > 0 && args(1) == "-v"
    println(s"==> ${interpret(is, verbose)}")

  def interpret(is: InputStream, verbose: Boolean): Int =
    val input = new ANTLRInputStream(is)
    // val lexer = new CalcLexer(input)
    val lexer = new ReportingPCFLexer(input)
    val tokens = new CommonTokenStream(lexer)
    val parser = new PCFParser(tokens)
    parser.removeErrorListeners()
    parser.addErrorListener(new ErrorListener())
    val tree = parser.term()
    if (verbose) println(s"ANTLR Parse Tree: ${tree.toStringTree(parser)}")
    if ! Error.flag then
      val visitor = new ASTVisitor
      val term = visitor.visit(tree).asInstanceOf[Term]
      if (verbose) println(s"AST: $term")
      val result = interp(term, Map())
      result
    else throw new SyntaxError(Error.msg)



