package es.ind.ordercriteria.app.usecase.products;

import es.ind.ordercriteria.config.common.mappers.ProductUseCaseModelMapper;
import es.ind.ordercriteria.config.common.mappers.ProductsByCriteriaRequestModelMapper;
import es.ind.ordercriteria.config.common.mappers.ProductsWithScoreMapper;
import es.ind.ordercriteria.domain.products.ProductCriteriaDomainService;
import es.ind.ordercriteria.domain.products.ProductRepository;
import es.ind.ordercriteria.domain.products.ProductWithValues;
import es.ind.ordercriteria.domain.products.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductsByCriteriaUseCaseImpl implements ProductsByCriteriaUseCase {

    private final ProductCriteriaDomainService domainService;
    private final ProductRepository repository;
    private final ProductsWithScoreMapper productsMapper;
    private final ProductUseCaseModelMapper productUseCaseModelMapper;



    @Override
    @Transactional
    public ProductsUseCaseModel getProductsByCriteria(List<ProductsByCriteriaUseCaseRequestModel> criterias) {


        List<ProductWithValues> productWithValues = domainService.getProductsWithValues();



        return ProductsUseCaseModel.builder()
                .products(generateScoreList(productWithValues,criterias).stream().sorted(Comparator.comparingDouble(ProductWithScore::getScore).reversed()).collect(Collectors.toList())
                .stream().map(productUseCaseModelMapper::productWithScoreToProductItemModel).collect(Collectors.toList()))
                .build();
    }

    private List<ProductWithScore> generateScoreList(List<ProductWithValues> productWithValuesList, List<ProductsByCriteriaUseCaseRequestModel> criterias){

        return productWithValuesList.stream().map(
                productWithValues -> generateProductScore(productWithValues,criterias)
        ).collect(Collectors.toList());
    }

    private ProductWithScore generateProductScore(ProductWithValues productWithValues, List<ProductsByCriteriaUseCaseRequestModel> criterias) {
        Double pondericedScore = criterias.stream().map(
                productsByCriteriaUseCaseRequestModel -> {
                    Object  value = productWithValues.getValues().get(productsByCriteriaUseCaseRequestModel.getColumn());
                    return ((Double)value)*productsByCriteriaUseCaseRequestModel.getWeight();
                }
        ).reduce(0.0D,Double::sum);
        Product p = repository.findById(productWithValues.getId()).get();
        ProductWithScore productWithScore = productsMapper.ProductsToProductsUseCaseModel(p);
        productWithScore.setScore(pondericedScore);
        return productWithScore;
    }


}
