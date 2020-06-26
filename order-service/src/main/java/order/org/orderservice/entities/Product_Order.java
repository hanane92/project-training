/*
package order.org.orderservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product_Order implements Serializable {

    @EmbeddedId
    private Product_Order_Key product_order_key;

    @ManyToOne
    @MapsId("FK_PRODUCT_ID")
    @JoinColumn(name = "FK_PRODUCT_ID")
    private Product product;

    @ManyToOne
    @MapsId("FK_ORDER_ID")
    @JoinColumn(name = "FK_ORDER_ID")
    private Orderr Orderr;
}
*/
