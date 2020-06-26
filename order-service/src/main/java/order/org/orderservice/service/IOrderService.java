package order.org.orderservice.service;

import order.org.orderservice.entities.Product;
import reactor.core.publisher.Flux;

import java.util.List;

public interface IOrderService {

    public Flux<Long> makeOrder(List<Long> products);
}
