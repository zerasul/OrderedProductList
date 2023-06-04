package es.ind.ordercriteria.domain.products;

import es.ind.ordercriteria.domain.products.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductCriteriaDomainServiceImpl implements ProductCriteriaDomainService {

    private final ProductRepository repository;

    @Override
    public List<ProductWithValues> getProductsWithValues() {
        List<Product> products = repository.findAll();

        return products.stream().map(this::
                generateProductWithValue
       ).collect(Collectors.toList());
    }

    private ProductWithValues generateProductWithValue(Product product) {

        Map<String, Object> values = Map.of(
                "name",product.getName(),
                "salesUnits",product.getSalesUnits().doubleValue(),
                "stockRatio",product.getStockRatio()
        );
        return ProductWithValues.builder()
                .id(product.getId())
                .values(values)
                .build();
    }
}
