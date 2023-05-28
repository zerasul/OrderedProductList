package es.ind.ordercriteria.domain.products;

import es.ind.ordercriteria.domain.products.entity.ProductCriteria;
import es.ind.ordercriteria.domain.products.exception.CriteriaNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductCriteriaDomainServiceImpl implements ProductCriteriaDomainService {

    private final ProductCriteriaRepository repository;

    @Override
    public ProductCriteria obtainCriteria(String name) {
        return repository.findOneByName(name).orElseThrow(CriteriaNotFoundException::new);
    }
}
