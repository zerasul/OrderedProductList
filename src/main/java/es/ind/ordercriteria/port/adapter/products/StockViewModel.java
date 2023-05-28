package es.ind.ordercriteria.port.adapter.products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockViewModel {

    private String size;
    private Long units;

}
