// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PCFParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, OP=7, LIT=8, WS=9, VAR=10;
	public static final int
		RULE_term = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"term"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'ifz'", "'let'", "'fun'", "'fix'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "OP", "LIT", "WS", "VAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PCFParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AppContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public AppContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitApp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BOpContext extends TermContext {
		public TerminalNode OP() { return getToken(PCFParser.OP, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public BOpContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitBOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FixContext extends TermContext {
		public TerminalNode VAR() { return getToken(PCFParser.VAR, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public FixContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitFix(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LitContext extends TermContext {
		public TerminalNode LIT() { return getToken(PCFParser.LIT, 0); }
		public LitContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitLit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends TermContext {
		public TerminalNode VAR() { return getToken(PCFParser.VAR, 0); }
		public VarContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetContext extends TermContext {
		public TerminalNode VAR() { return getToken(PCFParser.VAR, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public LetContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfZContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public IfZContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitIfZ(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunContext extends TermContext {
		public TerminalNode VAR() { return getToken(PCFParser.VAR, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public FunContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_term);
		try {
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new LitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(2);
				match(LIT);
				}
				break;
			case 2:
				_localctx = new BOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(3);
				match(T__0);
				setState(4);
				match(OP);
				setState(5);
				term();
				setState(6);
				term();
				setState(7);
				match(T__1);
				}
				break;
			case 3:
				_localctx = new IfZContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(9);
				match(T__0);
				setState(10);
				match(T__2);
				setState(11);
				term();
				setState(12);
				term();
				setState(13);
				term();
				setState(14);
				match(T__1);
				}
				break;
			case 4:
				_localctx = new VarContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(16);
				match(VAR);
				}
				break;
			case 5:
				_localctx = new LetContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(17);
				match(T__0);
				setState(18);
				match(T__3);
				setState(19);
				match(VAR);
				setState(20);
				term();
				setState(21);
				term();
				setState(22);
				match(T__1);
				}
				break;
			case 6:
				_localctx = new AppContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(24);
				match(T__0);
				setState(25);
				term();
				setState(26);
				term();
				setState(27);
				match(T__1);
				}
				break;
			case 7:
				_localctx = new FunContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(29);
				match(T__0);
				setState(30);
				match(T__4);
				setState(31);
				match(VAR);
				setState(32);
				term();
				setState(33);
				match(T__1);
				}
				break;
			case 8:
				_localctx = new FixContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(35);
				match(T__0);
				setState(36);
				match(T__5);
				setState(37);
				match(VAR);
				setState(38);
				term();
				setState(39);
				match(T__1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\n,\u0002\u0000\u0007\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0003\u0000*\b\u0000\u0001\u0000\u0000\u0000\u0001\u0000\u0000"+
		"\u00001\u0000)\u0001\u0000\u0000\u0000\u0002*\u0005\b\u0000\u0000\u0003"+
		"\u0004\u0005\u0001\u0000\u0000\u0004\u0005\u0005\u0007\u0000\u0000\u0005"+
		"\u0006\u0003\u0000\u0000\u0000\u0006\u0007\u0003\u0000\u0000\u0000\u0007"+
		"\b\u0005\u0002\u0000\u0000\b*\u0001\u0000\u0000\u0000\t\n\u0005\u0001"+
		"\u0000\u0000\n\u000b\u0005\u0003\u0000\u0000\u000b\f\u0003\u0000\u0000"+
		"\u0000\f\r\u0003\u0000\u0000\u0000\r\u000e\u0003\u0000\u0000\u0000\u000e"+
		"\u000f\u0005\u0002\u0000\u0000\u000f*\u0001\u0000\u0000\u0000\u0010*\u0005"+
		"\n\u0000\u0000\u0011\u0012\u0005\u0001\u0000\u0000\u0012\u0013\u0005\u0004"+
		"\u0000\u0000\u0013\u0014\u0005\n\u0000\u0000\u0014\u0015\u0003\u0000\u0000"+
		"\u0000\u0015\u0016\u0003\u0000\u0000\u0000\u0016\u0017\u0005\u0002\u0000"+
		"\u0000\u0017*\u0001\u0000\u0000\u0000\u0018\u0019\u0005\u0001\u0000\u0000"+
		"\u0019\u001a\u0003\u0000\u0000\u0000\u001a\u001b\u0003\u0000\u0000\u0000"+
		"\u001b\u001c\u0005\u0002\u0000\u0000\u001c*\u0001\u0000\u0000\u0000\u001d"+
		"\u001e\u0005\u0001\u0000\u0000\u001e\u001f\u0005\u0005\u0000\u0000\u001f"+
		" \u0005\n\u0000\u0000 !\u0003\u0000\u0000\u0000!\"\u0005\u0002\u0000\u0000"+
		"\"*\u0001\u0000\u0000\u0000#$\u0005\u0001\u0000\u0000$%\u0005\u0006\u0000"+
		"\u0000%&\u0005\n\u0000\u0000&\'\u0003\u0000\u0000\u0000\'(\u0005\u0002"+
		"\u0000\u0000(*\u0001\u0000\u0000\u0000)\u0002\u0001\u0000\u0000\u0000"+
		")\u0003\u0001\u0000\u0000\u0000)\t\u0001\u0000\u0000\u0000)\u0010\u0001"+
		"\u0000\u0000\u0000)\u0011\u0001\u0000\u0000\u0000)\u0018\u0001\u0000\u0000"+
		"\u0000)\u001d\u0001\u0000\u0000\u0000)#\u0001\u0000\u0000\u0000*\u0001"+
		"\u0001\u0000\u0000\u0000\u0001)";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}