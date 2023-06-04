package es.ind.ordercriteria.config.common.mappers;

import es.ind.ordercriteria.app.usecase.products.ProductItemModel;
import es.ind.ordercriteria.app.usecase.products.ProductWithScore;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductUseCaseModelMapper {

    ProductItemModel productWithScoreToProductItemModel(ProductWithScore product);
}
