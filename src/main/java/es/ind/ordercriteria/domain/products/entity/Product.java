package es.ind.ordercriteria.domain.products.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Table(name = "Products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "sales_unit")
    private Long salesUnits;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Stock> stock;

    @Column(name="totalStock")
    private Long totalStock;

    @PrePersist
    @PreUpdate
    public void onPersist(){
        this.totalStock=this.stock.stream().map(Stock::getUnits).
                reduce(0L,Long::sum);
    }

    public void addStock(Stock stock){
        stock.setProduct(this);
        this.stock.add(stock);
    }
}
