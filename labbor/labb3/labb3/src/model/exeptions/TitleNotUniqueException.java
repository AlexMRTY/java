package model.exeptions;

public class TitleNotUniqueException extends RuntimeException {
    public TitleNotUniqueException() {
        super("Title is not unique");
    }
    public TitleNotUniqueException(String message) {
        super(message);
    }
}
