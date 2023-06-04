package es.ind.ordercriteria.app.usecase.products;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductsByCriteriaUseCaseRequestModel {


    private String name;
    @NotNull
    private Integer weight;
    @NotBlank
    private String column;
}
