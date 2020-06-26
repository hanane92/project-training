package order.org.orderservice.web;

import order.org.orderservice.dao.ProductRepository;
import order.org.orderservice.service.OrderService;
import order.org.orderservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping(value = "/order/create")
    public Flux<Long> createOrder(@RequestParam(name = "pids") List<Long> productIds){

         return orderService.makeOrder(productIds);
    }
}
