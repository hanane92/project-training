package com.epo.trainingproject.orderservice.entities;

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
public class ProductType implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String type;


}
