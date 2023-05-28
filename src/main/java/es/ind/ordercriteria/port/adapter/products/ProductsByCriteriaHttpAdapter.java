package es.ind.ordercriteria.port.adapter.products;

import es.ind.ordercriteria.app.usecase.products.ProductsByCriteriaUseCase;
import es.ind.ordercriteria.config.common.mappers.ProductsViewModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class ProductsByCriteriaHttpAdapter implements ProductsByCriteriaPort {

    private final ProductsViewModelMapper productsMapper;
    private final ProductsByCriteriaUseCase useCase;

    @Override
    @GetMapping("/products/criteria/{criteria}")
    public ProductsViewModel getProductsByCriteria(@PathVariable String criteria) {

        return productsMapper.ProductsUSeCaseModelToProductsViewModel(useCase.getProductsByCriteria(criteria));

    }
}
