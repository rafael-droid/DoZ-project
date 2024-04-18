package pl.doz.DoZproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private Product product;
    private boolean isPromotion;
}
