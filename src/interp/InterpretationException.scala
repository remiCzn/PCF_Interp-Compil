package interp

class InterpretationException(val x: String) extends Exception(s"Not defined variable: ${x}") {}
class WrongConversionException extends Exception("Can't convert this")