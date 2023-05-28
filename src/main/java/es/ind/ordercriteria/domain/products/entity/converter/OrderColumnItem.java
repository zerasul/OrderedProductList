package es.ind.ordercriteria.domain.products.entity.converter;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderColumnItem {

    private String name;

    private String direction;
}
