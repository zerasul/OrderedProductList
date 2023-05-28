package es.ind.ordercriteria.port.adapter.products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductItemViewModel {

    private String name;
    private Long salesUnits;
    private Set<StockViewModel> stock;
}
