package pl.doz.DoZproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.doz.DoZproject.model.enums.KindProduct;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private KindProduct kindProduct;
    private String insertionDate;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "pricelist_id")
    private PriceList priceList;
    @ManyToMany(mappedBy = "products")
    private List<SaleSummary> saleSummaryList = new ArrayList<>();

}
