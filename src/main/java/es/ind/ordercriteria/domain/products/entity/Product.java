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

    @Column(name="stockRatio")
    private Double stockRatio;

    @PrePersist
    @PreUpdate
    public void onPersist(){
        Double totalStock=this.stock.stream().map(Stock::getUnits).
                reduce(0L,Long::sum).doubleValue();
        Double totalUnits = totalStock+this.salesUnits;
        this.stockRatio= (totalStock/totalUnits)*100;
    }

    public void addStock(Stock stock){
        stock.setProduct(this);
        this.stock.add(stock);
    }
}
