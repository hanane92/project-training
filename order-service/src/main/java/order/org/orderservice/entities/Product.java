package order.org.orderservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Product implements Serializable {

    @Id @GeneratedValue(strategy =GenerationType.AUTO)
    private Long Id;

    private String name;
    private String description;
    private double price;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_STOCK_ID", referencedColumnName = "Id")
    private Stock stock;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product_types productTypes;

}
