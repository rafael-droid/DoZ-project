package pl.doz.DoZproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.doz.DoZproject.model.PriceList;
import pl.doz.DoZproject.model.Product;

import java.util.Optional;

@Repository
public interface PriceListRepository extends JpaRepository<PriceList, Long> {
    //Optional<PriceList> findPriceListByProductId(Long id);
    
}
