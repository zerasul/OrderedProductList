package es.ind.ordercriteria.domain.products;


import es.ind.ordercriteria.domain.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


}
