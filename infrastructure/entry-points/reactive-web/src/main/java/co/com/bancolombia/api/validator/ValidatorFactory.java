package co.com.bancolombia.api.validator;

import co.com.bancolombia.api.dto.request.UserRequestDTO;
import co.com.bancolombia.model.enums.TechnicalMessage;
import co.com.bancolombia.model.exceptions.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ValidatorFactory {

    private final Map<Class<?>, Validator> validatorMap;

    public ValidatorFactory() {
        this.validatorMap = new HashMap<>();
        validatorMap.put(UserRequestDTO.class, new UserRequestValidator());
    }

    public <T> void validateRequest(T request) {
        Class<?> requestClass = request.getClass();
        Errors errors = new BeanPropertyBindingResult(request, requestClass.getSimpleName());
        Validator validator = validatorMap.get(requestClass);

        validator.validate(request, errors);

        if (errors.hasErrors()) {

            String errorDetails = errors.getAllErrors().stream()
                    .map(error -> {
                        String internalCode = error.getCode();
                        String errorMessage = error.getDefaultMessage();
                        return String.format("Código interno: %s, Mensaje: %s", internalCode, errorMessage);
                    })
                    .collect(Collectors.joining(" | "));

            throw new ValidationException(errorDetails);
        }
    }

}

