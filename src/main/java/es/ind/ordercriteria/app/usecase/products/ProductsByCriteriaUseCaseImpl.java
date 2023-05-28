package es.ind.ordercriteria.app.usecase.products;

import es.ind.ordercriteria.config.common.mappers.ProductsUseCaseMapper;
import es.ind.ordercriteria.domain.products.ProductCriteriaDomainService;
import es.ind.ordercriteria.domain.products.ProductRepository;
import es.ind.ordercriteria.domain.products.entity.Product;
import es.ind.ordercriteria.domain.products.entity.ProductCriteria;
import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductsByCriteriaUseCaseImpl implements ProductsByCriteriaUseCase {

    private final ProductCriteriaDomainService domainService;
    private final ProductRepository repository;
    private final ProductsUseCaseMapper productsMapper;


    @Override
    @Transactional
    public ProductsUseCaseModel getProductsByCriteria(String criteria) {
        ProductCriteria pcriteria = domainService.obtainCriteria(criteria);

        List<Sort.Order> orders = pcriteria.getOrderColumns().stream().map(
                orderColumnItem -> new Sort.Order(Sort.Direction.valueOf(orderColumnItem.getDirection()),
                        orderColumnItem.getName())
        ).collect(Collectors.toList());
        List<Product> products = repository.findAll(Sort.by(orders));
        return ProductsUseCaseModel.builder()
                .products(products.stream().map(productsMapper::ProductsToProductsUseCaseModel).collect(Collectors.toList()))
                .build();
    }
}
