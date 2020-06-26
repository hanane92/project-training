package com.epo.trainingproject.orderservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orders implements Serializable {

    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private double totalPrice;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private List<Product> products;


}
