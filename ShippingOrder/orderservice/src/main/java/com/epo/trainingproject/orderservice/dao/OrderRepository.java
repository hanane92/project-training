package com.epo.trainingproject.orderservice.dao;

import com.epo.trainingproject.orderservice.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Orders,Long> {
}
