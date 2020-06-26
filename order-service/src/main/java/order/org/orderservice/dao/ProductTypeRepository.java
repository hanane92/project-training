package order.org.orderservice.dao;

import order.org.orderservice.entities.Product_types;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductTypeRepository extends JpaRepository<Product_types,Long > {

    //public pro findByTypeContainingAnd(String expression);
    //public Long getIdp(String desc,Product_types pt);
}
