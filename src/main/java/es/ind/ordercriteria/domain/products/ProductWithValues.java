package es.ind.ordercriteria.domain.products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductWithValues {

  private Long id;
  private Map<String, Object> values;
}
