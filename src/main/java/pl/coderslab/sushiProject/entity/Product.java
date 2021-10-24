package pl.coderslab.sushiProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Size(min=2)
    private String name;
    @NotEmpty
    @Size(max = 400)
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(scale = 2, precision = 5)
    private BigDecimal price;

}
