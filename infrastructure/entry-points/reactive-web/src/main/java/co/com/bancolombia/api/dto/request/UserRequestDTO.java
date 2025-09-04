package co.com.bancolombia.api.dto.request;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String address;
    private String phoneNumber;
    private String email;
    private BigDecimal salary;
}
