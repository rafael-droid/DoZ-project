package pl.doz.DoZproject.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class PriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private boolean isPromotion;
}
