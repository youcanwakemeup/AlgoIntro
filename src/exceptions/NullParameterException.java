package exceptions;

public class NullParameterException extends IllegalArgumentException {
    public NullParameterException(String s) {
        super(s);
    }
}
