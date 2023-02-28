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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, OP1=12, OP2=13, LIT=14, WS=15, VAR=16;
	public static final int
		RULE_term = 0, RULE_assign = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"term", "assign"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'ifz'", "'then'", "'else'", "'let'", "'in'", "'fun'", 
			"'->'", "'fix'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"OP1", "OP2", "LIT", "WS", "VAR"
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
	public static class ParContext extends TermContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ParContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitPar(this);
			else return visitor.visitChildren(this);
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
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode OP1() { return getToken(PCFParser.OP1, 0); }
		public TerminalNode OP2() { return getToken(PCFParser.OP2, 0); }
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
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
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
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				_localctx = new LitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(5);
				match(LIT);
				}
				break;
			case 2:
				{
				_localctx = new BOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(6);
				match(T__0);
				setState(7);
				term(0);
				setState(8);
				match(OP1);
				setState(9);
				term(0);
				setState(10);
				match(T__1);
				}
				break;
			case 3:
				{
				_localctx = new BOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(12);
				match(T__0);
				setState(13);
				term(0);
				setState(14);
				match(OP2);
				setState(15);
				term(0);
				setState(16);
				match(T__1);
				}
				break;
			case 4:
				{
				_localctx = new IfZContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(18);
				match(T__2);
				setState(19);
				term(0);
				setState(20);
				match(T__3);
				setState(21);
				term(0);
				setState(22);
				match(T__4);
				setState(23);
				term(6);
				}
				break;
			case 5:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				match(VAR);
				}
				break;
			case 6:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(T__5);
				setState(27);
				assign();
				setState(28);
				match(T__6);
				setState(29);
				term(4);
				}
				break;
			case 7:
				{
				_localctx = new FunContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(31);
				match(T__7);
				setState(32);
				match(VAR);
				setState(33);
				match(T__8);
				setState(34);
				term(3);
				}
				break;
			case 8:
				{
				_localctx = new FixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(35);
				match(T__9);
				setState(36);
				match(VAR);
				setState(37);
				term(2);
				}
				break;
			case 9:
				{
				_localctx = new ParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38);
				match(T__0);
				setState(39);
				term(0);
				setState(40);
				match(T__1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(52);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new AppContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(44);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(45);
						term(12);
						}
						break;
					case 2:
						{
						_localctx = new BOpContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(46);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(47);
						match(OP1);
						setState(48);
						term(9);
						}
						break;
					case 3:
						{
						_localctx = new BOpContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(49);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(50);
						match(OP2);
						setState(51);
						term(8);
						}
						break;
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(PCFParser.VAR, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(VAR);
			setState(58);
			match(T__10);
			setState(59);
			term(0);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0010>\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0003\u0000+\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005"+
		"\u00005\b\u0000\n\u0000\f\u00008\t\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0002\u0000\u0002\u0000"+
		"\u0000F\u0000*\u0001\u0000\u0000\u0000\u00029\u0001\u0000\u0000\u0000"+
		"\u0004\u0005\u0006\u0000\uffff\uffff\u0000\u0005+\u0005\u000e\u0000\u0000"+
		"\u0006\u0007\u0005\u0001\u0000\u0000\u0007\b\u0003\u0000\u0000\u0000\b"+
		"\t\u0005\f\u0000\u0000\t\n\u0003\u0000\u0000\u0000\n\u000b\u0005\u0002"+
		"\u0000\u0000\u000b+\u0001\u0000\u0000\u0000\f\r\u0005\u0001\u0000\u0000"+
		"\r\u000e\u0003\u0000\u0000\u0000\u000e\u000f\u0005\r\u0000\u0000\u000f"+
		"\u0010\u0003\u0000\u0000\u0000\u0010\u0011\u0005\u0002\u0000\u0000\u0011"+
		"+\u0001\u0000\u0000\u0000\u0012\u0013\u0005\u0003\u0000\u0000\u0013\u0014"+
		"\u0003\u0000\u0000\u0000\u0014\u0015\u0005\u0004\u0000\u0000\u0015\u0016"+
		"\u0003\u0000\u0000\u0000\u0016\u0017\u0005\u0005\u0000\u0000\u0017\u0018"+
		"\u0003\u0000\u0000\u0006\u0018+\u0001\u0000\u0000\u0000\u0019+\u0005\u0010"+
		"\u0000\u0000\u001a\u001b\u0005\u0006\u0000\u0000\u001b\u001c\u0003\u0002"+
		"\u0001\u0000\u001c\u001d\u0005\u0007\u0000\u0000\u001d\u001e\u0003\u0000"+
		"\u0000\u0004\u001e+\u0001\u0000\u0000\u0000\u001f \u0005\b\u0000\u0000"+
		" !\u0005\u0010\u0000\u0000!\"\u0005\t\u0000\u0000\"+\u0003\u0000\u0000"+
		"\u0003#$\u0005\n\u0000\u0000$%\u0005\u0010\u0000\u0000%+\u0003\u0000\u0000"+
		"\u0002&\'\u0005\u0001\u0000\u0000\'(\u0003\u0000\u0000\u0000()\u0005\u0002"+
		"\u0000\u0000)+\u0001\u0000\u0000\u0000*\u0004\u0001\u0000\u0000\u0000"+
		"*\u0006\u0001\u0000\u0000\u0000*\f\u0001\u0000\u0000\u0000*\u0012\u0001"+
		"\u0000\u0000\u0000*\u0019\u0001\u0000\u0000\u0000*\u001a\u0001\u0000\u0000"+
		"\u0000*\u001f\u0001\u0000\u0000\u0000*#\u0001\u0000\u0000\u0000*&\u0001"+
		"\u0000\u0000\u0000+6\u0001\u0000\u0000\u0000,-\n\u000b\u0000\u0000-5\u0003"+
		"\u0000\u0000\f./\n\b\u0000\u0000/0\u0005\f\u0000\u000005\u0003\u0000\u0000"+
		"\t12\n\u0007\u0000\u000023\u0005\r\u0000\u000035\u0003\u0000\u0000\b4"+
		",\u0001\u0000\u0000\u00004.\u0001\u0000\u0000\u000041\u0001\u0000\u0000"+
		"\u000058\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000"+
		"\u0000\u00007\u0001\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u0000"+
		"9:\u0005\u0010\u0000\u0000:;\u0005\u000b\u0000\u0000;<\u0003\u0000\u0000"+
		"\u0000<\u0003\u0001\u0000\u0000\u0000\u0003*46";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}