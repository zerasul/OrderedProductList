package es.ind.ordercriteria.app.usecase.products;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductWithScore extends ProductItemModel{

    private Double Score;

}
