package co.com.bancolombia.api.validator;

import co.com.bancolombia.api.dto.request.UserRequestDTO;
import co.com.bancolombia.model.enums.TechnicalMessage;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;

public class UserRequestValidator implements Validator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    );

    @Override
    public boolean supports(Class<?> clazz) {
        return UserRequestDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        UserRequestDTO request = (UserRequestDTO)target;

        this.validateRequiredFields(request, errors);
        this.validateEmail(request, errors);

    }

    private void validateRequiredFields(UserRequestDTO request, Errors errors){

        Map<String, Function<UserRequestDTO, Object>> fieldsGetters = Map.of(
                "firstName", UserRequestDTO::getFirstName,
                "lastName", UserRequestDTO::getLastName,
                "email", UserRequestDTO::getEmail,
                "salary", UserRequestDTO::getSalary
        );

        fieldsGetters.forEach((fieldName, getter) ->{
            Object value = getter.apply(request);
            if (value == null) {
                addError(errors, fieldName, TechnicalMessage.FIELD_REQUIRED);
            }
            else if (value instanceof String && ((String) value).isBlank()) {
                addError(errors, fieldName, TechnicalMessage.FIELD_REQUIRED);
            }
        });

    }

    private void validateEmail(UserRequestDTO request, Errors errors) {
        String email = request.getEmail();
        if (email != null && !email.isBlank()) {
            if (!EMAIL_PATTERN.matcher(email).matches()) {
                addError(errors, "email", TechnicalMessage.INVALID_FORMAT);
            }
        }
    }

    private void addError(Errors errors, String fieldName, TechnicalMessage technicalMessage) {
        errors.rejectValue(fieldName, technicalMessage.getCode(), technicalMessage.formatMessage(fieldName));
    }


}
