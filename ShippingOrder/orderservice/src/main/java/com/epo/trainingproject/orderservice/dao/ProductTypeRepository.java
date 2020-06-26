package com.epo.trainingproject.orderservice.dao;

import com.epo.trainingproject.orderservice.entities.Product;
import com.epo.trainingproject.orderservice.entities.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductTypeRepository extends JpaRepository<ProductType,Long> {

    @Query("select p.Id from Product p where p.productTypes.type=:t")
    Long findProductIdByTypeContains(@Param("t") String type);

}
