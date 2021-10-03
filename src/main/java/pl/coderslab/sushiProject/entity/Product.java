package pl.coderslab.sushiProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min=2, max = 20)
    private String name;
    @NotBlank
    @Size(min = 5, max = 400)
    private String description;
    @Min(1)
    private int quantity;
    @DecimalMin("1.00")
    @DecimalMax("200.00")
    private BigDecimal price;

}
