package co.com.bancolombia.model.exceptions;

public class ValidationException  extends ApiException{

    public ValidationException(String message) {
        super(message);
    }
}
