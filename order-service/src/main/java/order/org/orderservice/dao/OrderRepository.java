package order.org.orderservice.dao;
import order.org.orderservice.entities.Ordere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Ordere, Long> {
}
