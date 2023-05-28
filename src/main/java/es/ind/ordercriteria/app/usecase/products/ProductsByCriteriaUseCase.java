package es.ind.ordercriteria.app.usecase.products;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
public interface ProductsByCriteriaUseCase {

    ProductsUseCaseModel getProductsByCriteria(@NotBlank String criteria);
}
