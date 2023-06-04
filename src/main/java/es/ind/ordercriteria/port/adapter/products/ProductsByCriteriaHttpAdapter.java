package es.ind.ordercriteria.port.adapter.products;

import es.ind.ordercriteria.app.usecase.products.ProductsByCriteriaUseCase;
import es.ind.ordercriteria.config.common.mappers.ProductsByCriteriaRequestModelMapper;
import es.ind.ordercriteria.config.common.mappers.ProductsViewModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class ProductsByCriteriaHttpAdapter implements ProductsByCriteriaPort {

    private final ProductsViewModelMapper productsMapper;
    private final ProductsByCriteriaRequestModelMapper productsByCriteriaRequestModelMapper;
    private final ProductsByCriteriaUseCase useCase;

    @Override
    @PostMapping("/products/criteria/")
    public ProductsViewModel getProductsByCriteria(@RequestBody List<ProductsByCriteriaRequestModel> criterias) {

        return productsMapper.ProductsUSeCaseModelToProductsViewModel(useCase.getProductsByCriteria(
                criterias.stream().map(productsByCriteriaRequestModelMapper::productsByCriteriaRequestModelToProductsByCriteriaUseCaseRequestModel)
                .collect(Collectors.toList())
        ));

    }
}
