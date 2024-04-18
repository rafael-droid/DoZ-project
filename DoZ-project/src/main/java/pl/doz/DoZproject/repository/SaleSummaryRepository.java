package pl.doz.DoZproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.doz.DoZproject.model.SaleSummary;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaleSummaryRepository extends JpaRepository<SaleSummary, Long> {
    List<SaleSummary> findSaleSummaryBySaleDate(String date);
}
