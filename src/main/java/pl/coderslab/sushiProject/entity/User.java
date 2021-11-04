package pl.coderslab.sushiProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    public User(String firstName, String lastName, String city, String postCode, String street, String number, int phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.postCode = postCode;
        this.street = street;
        this.number = number;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
