package order.org.orderservice.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ordere implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private double totalPrice;

    /*@OneToMany(mappedBy = "Orderr")
    private Set<Product_Order> productOrders;*/

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private Set<Product> products;




}
