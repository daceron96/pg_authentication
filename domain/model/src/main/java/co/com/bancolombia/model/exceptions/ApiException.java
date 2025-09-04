package co.com.bancolombia.model.exceptions;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }
}
