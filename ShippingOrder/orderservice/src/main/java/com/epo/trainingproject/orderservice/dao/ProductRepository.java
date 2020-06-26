package com.epo.trainingproject.orderservice.dao;

import com.epo.trainingproject.orderservice.entities.Product;
import com.epo.trainingproject.orderservice.entities.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long> {


}
