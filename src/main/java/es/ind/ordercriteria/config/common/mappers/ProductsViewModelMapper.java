package es.ind.ordercriteria.config.common.mappers;

import es.ind.ordercriteria.app.usecase.products.ProductsUseCaseModel;
import es.ind.ordercriteria.port.adapter.products.ProductsViewModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductsViewModelMapper {

    ProductsViewModel ProductsUSeCaseModelToProductsViewModel(ProductsUseCaseModel source);
}
