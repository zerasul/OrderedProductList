package es.ind.ordercriteria.domain.products.entity;

import es.ind.ordercriteria.domain.products.entity.converter.OrderColumnConverter;
import es.ind.ordercriteria.domain.products.entity.converter.OrderColumnItem;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "ProductCriteria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCriteria {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "orderColumns", nullable = false)
    @Convert(converter = OrderColumnConverter.class)
    private List<OrderColumnItem> orderColumns;
}
