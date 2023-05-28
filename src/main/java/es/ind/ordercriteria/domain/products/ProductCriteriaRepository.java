package es.ind.ordercriteria.domain.products;

import es.ind.ordercriteria.domain.products.entity.ProductCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCriteriaRepository extends JpaRepository<ProductCriteria,Long> {

    Optional<ProductCriteria> findOneByName(String name);
}
