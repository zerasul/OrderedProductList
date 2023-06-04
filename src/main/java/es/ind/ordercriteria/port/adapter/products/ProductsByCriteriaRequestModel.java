package es.ind.ordercriteria.port.adapter.products;

import lombok.Data;

@Data
public class ProductsByCriteriaRequestModel {

    private String name;
    private Integer weight;
    private String column;
}
