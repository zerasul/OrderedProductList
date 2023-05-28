package es.ind.ordercriteria.domain.products;

import es.ind.ordercriteria.domain.products.entity.ProductCriteria;

public interface ProductCriteriaDomainService {

    ProductCriteria obtainCriteria(String name);
}
