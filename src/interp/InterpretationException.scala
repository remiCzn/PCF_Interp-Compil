package interp

class InterpretationException extends Exception("Not defined variable") {}
class WrongConversionException extends Exception("Can't convert this")