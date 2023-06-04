package es.ind.ordercriteria.config.common.mappers;


import es.ind.ordercriteria.app.usecase.products.ProductsByCriteriaUseCaseRequestModel;
import es.ind.ordercriteria.port.adapter.products.ProductsByCriteriaRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductsByCriteriaRequestModelMapper {

    ProductsByCriteriaUseCaseRequestModel productsByCriteriaRequestModelToProductsByCriteriaUseCaseRequestModel(ProductsByCriteriaRequestModel requestModel);
}
