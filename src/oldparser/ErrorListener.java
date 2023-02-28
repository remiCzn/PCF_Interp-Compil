package oldparser;

import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import parser.Error;

// not so easy to translate in Scala - let's keep it in Java
public class ErrorListener extends ConsoleErrorListener {
    public ErrorListener(){
        parser.Error.flag_$eq(false); // no error by default
    }
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine, String msg, RecognitionException e) {
        super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
        parser.Error.flag_$eq(true); // report error
        Error.msg_$eq(msg);
    }
}
