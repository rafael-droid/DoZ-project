package pl.doz.DoZproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.doz.DoZproject.model.PriceList;
import pl.doz.DoZproject.model.Product;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findFirstByPriceList(PriceList priceList);

    Optional<Product> findProductByPriceList(PriceList priceList);
}
