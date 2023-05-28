package es.ind.ordercriteria.app.usecase.products;

import lombok.Data;

import java.util.Set;

@Data
public class ProductItemModel {

    private String name;
    private Long salesUnits;
    private Set<StockModel> stock;
}
