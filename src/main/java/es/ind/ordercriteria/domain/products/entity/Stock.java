package es.ind.ordercriteria.domain.products.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stocks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stock {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="size")
    private String size;

    @Column(name="units")
    private Long units;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduct")
    private Product product;
}
