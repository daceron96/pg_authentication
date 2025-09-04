package co.com.bancolombia.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TechnicalMessage {

    FIELD_REQUIRED("El campo %s es requerido", "ERR-001", "API-ERR-001"),
    INVALID_FORMAT("El campo %s no tiene un formato válido", "ERR-002", "API-ERR-002");

    private final String message;
    private final String code;
    private final String externalCode;

    public String formatMessage(String fieldName) {
        return String.format(message, fieldName);
    }
}
