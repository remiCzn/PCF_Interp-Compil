// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PCFLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, OP1=12, OP2=13, LIT=14, WS=15, VAR=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "OP1", "OP2", "LIT", "WS", "VAR"
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


	public PCFLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PCF.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0010g\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0005\rO\b\r\n\r\f\rR\t\r\u0003\rT\b\r\u0001\u000e\u0004\u000eW\b\u000e"+
		"\u000b\u000e\f\u000eX\u0001\u000e\u0001\u000e\u0001\u000f\u0004\u000f"+
		"^\b\u000f\u000b\u000f\f\u000f_\u0001\u000f\u0005\u000fc\b\u000f\n\u000f"+
		"\f\u000ff\t\u000f\u0000\u0000\u0010\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010\u0001\u0000"+
		"\u0007\u0002\u0000**//\u0002\u0000++--\u0001\u000019\u0001\u000009\u0003"+
		"\u0000\t\n\r\r  \u0003\u0000AZ__az\u0004\u000009AZ__azk\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0001!\u0001\u0000\u0000\u0000"+
		"\u0003#\u0001\u0000\u0000\u0000\u0005%\u0001\u0000\u0000\u0000\u0007)"+
		"\u0001\u0000\u0000\u0000\t.\u0001\u0000\u0000\u0000\u000b3\u0001\u0000"+
		"\u0000\u0000\r7\u0001\u0000\u0000\u0000\u000f:\u0001\u0000\u0000\u0000"+
		"\u0011>\u0001\u0000\u0000\u0000\u0013A\u0001\u0000\u0000\u0000\u0015E"+
		"\u0001\u0000\u0000\u0000\u0017G\u0001\u0000\u0000\u0000\u0019I\u0001\u0000"+
		"\u0000\u0000\u001bS\u0001\u0000\u0000\u0000\u001dV\u0001\u0000\u0000\u0000"+
		"\u001f]\u0001\u0000\u0000\u0000!\"\u0005(\u0000\u0000\"\u0002\u0001\u0000"+
		"\u0000\u0000#$\u0005)\u0000\u0000$\u0004\u0001\u0000\u0000\u0000%&\u0005"+
		"i\u0000\u0000&\'\u0005f\u0000\u0000\'(\u0005z\u0000\u0000(\u0006\u0001"+
		"\u0000\u0000\u0000)*\u0005t\u0000\u0000*+\u0005h\u0000\u0000+,\u0005e"+
		"\u0000\u0000,-\u0005n\u0000\u0000-\b\u0001\u0000\u0000\u0000./\u0005e"+
		"\u0000\u0000/0\u0005l\u0000\u000001\u0005s\u0000\u000012\u0005e\u0000"+
		"\u00002\n\u0001\u0000\u0000\u000034\u0005l\u0000\u000045\u0005e\u0000"+
		"\u000056\u0005t\u0000\u00006\f\u0001\u0000\u0000\u000078\u0005i\u0000"+
		"\u000089\u0005n\u0000\u00009\u000e\u0001\u0000\u0000\u0000:;\u0005f\u0000"+
		"\u0000;<\u0005u\u0000\u0000<=\u0005n\u0000\u0000=\u0010\u0001\u0000\u0000"+
		"\u0000>?\u0005-\u0000\u0000?@\u0005>\u0000\u0000@\u0012\u0001\u0000\u0000"+
		"\u0000AB\u0005f\u0000\u0000BC\u0005i\u0000\u0000CD\u0005x\u0000\u0000"+
		"D\u0014\u0001\u0000\u0000\u0000EF\u0005=\u0000\u0000F\u0016\u0001\u0000"+
		"\u0000\u0000GH\u0007\u0000\u0000\u0000H\u0018\u0001\u0000\u0000\u0000"+
		"IJ\u0007\u0001\u0000\u0000J\u001a\u0001\u0000\u0000\u0000KT\u00050\u0000"+
		"\u0000LP\u0007\u0002\u0000\u0000MO\u0007\u0003\u0000\u0000NM\u0001\u0000"+
		"\u0000\u0000OR\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001"+
		"\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000"+
		"SK\u0001\u0000\u0000\u0000SL\u0001\u0000\u0000\u0000T\u001c\u0001\u0000"+
		"\u0000\u0000UW\u0007\u0004\u0000\u0000VU\u0001\u0000\u0000\u0000WX\u0001"+
		"\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000"+
		"YZ\u0001\u0000\u0000\u0000Z[\u0006\u000e\u0000\u0000[\u001e\u0001\u0000"+
		"\u0000\u0000\\^\u0007\u0005\u0000\u0000]\\\u0001\u0000\u0000\u0000^_\u0001"+
		"\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000"+
		"`d\u0001\u0000\u0000\u0000ac\u0007\u0006\u0000\u0000ba\u0001\u0000\u0000"+
		"\u0000cf\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000"+
		"\u0000\u0000e \u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000\u0006"+
		"\u0000PSX_d\u0001\u0000\u0001\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}