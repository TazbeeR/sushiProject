package pl.coderslab.sushiProject.entity.DTO;

import lombok.*;
import org.springframework.stereotype.Component;
import pl.coderslab.sushiProject.entity.Delivery;

import javax.validation.constraints.*;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserOrderDTO {
    @NotBlank
    @Size(min = 3)
    private String firstName;

    @NotBlank
    @Size(min = 3)
    private String lastName;

    @NotEmpty
    @Size(min=3)
    private String city;

    @NotEmpty
    @Pattern(regexp = "[0-9][0-9]-[0-9][0-9][0-9]")
    private String postCode;

    @NotEmpty
    @Size(min = 3)
    private String street;

    @NotBlank
    private String number;

    @NotNull
    @Min(500000000)
    @Max(899999999)
    private int phoneNumber;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private Delivery delivery;
//    @NotNull
//    private List<OrderItem> orderItemList;
//    @NotNull
//    private BigDecimal finalPrice;
    @NotBlank
    private String payment;


}
