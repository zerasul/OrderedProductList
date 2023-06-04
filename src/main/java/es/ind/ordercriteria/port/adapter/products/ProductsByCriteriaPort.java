package es.ind.ordercriteria.port.adapter.products;

import java.util.List;

public interface ProductsByCriteriaPort {

    ProductsViewModel getProductsByCriteria(List<ProductsByCriteriaRequestModel> criterias);
}
