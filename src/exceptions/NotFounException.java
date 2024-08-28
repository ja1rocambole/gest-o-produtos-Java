package exceptions;

public class NotFounException extends RuntimeException {
    public NotFounException(){
        super("Not found.");
    }

    public NotFounException(String message){
        super(message);
    }
}
