package pl.doz.DoZproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Setter
public class SaleSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String saleDate; //{yyyy-mm-dd}
    private int amount;
    private double priceSale;
    @ManyToMany
    @JoinTable(name = "products_saleSummary",
            joinColumns = @JoinColumn(name = "saleSummary"),
            inverseJoinColumns = @JoinColumn(name = "products"))
    private List<Product> products = new ArrayList<>();
}
