package es.ind.ordercriteria.app.usecase.products;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Validated
public interface ProductsByCriteriaUseCase {

    ProductsUseCaseModel getProductsByCriteria(@Valid @NotEmpty List<ProductsByCriteriaUseCaseRequestModel> criterias);
}
