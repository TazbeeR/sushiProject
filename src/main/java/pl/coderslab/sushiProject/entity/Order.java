package pl.coderslab.sushiProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.profile.Fetch;

import javax.persistence.*;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @OneToOne
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    private Delivery delivery;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItemList;

    @Column(scale = 2, precision = 5)
    private BigDecimal finalPrice;

    private String payment;

    public Order(User user, Delivery delivery, String payment) {
        this.user = user;
        this.delivery = delivery;
        this.payment = payment;
    }
}
