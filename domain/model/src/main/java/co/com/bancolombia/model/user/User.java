package co.com.bancolombia.model.user;
import lombok.*;
//import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String address;
    private String phoneNumber;
    private String email;
    private BigDecimal salary;
}

