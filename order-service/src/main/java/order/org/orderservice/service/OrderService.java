package order.org.orderservice.service;

import order.org.orderservice.dao.ProductRepository;
import order.org.orderservice.dao.StockRepository;
import order.org.orderservice.entities.Product;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.*;

@Service
@Transactional
public class OrderService implements IOrderService {

    @Autowired
    private IProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

    WebClient webClient;


    @Override
    public Flux<Long> makeOrder(List<Long> products) {

        Set<Long> newList = new HashSet<>(products);
        newList.forEach(id->{
            Product p = productService.checkProduct(id);
            int fr = frequency(products, id);
            System.out.println("prod: "+id+" freq: "+fr);
            if(fr>p.getStock().getAmount()){
                productService.addStocktoProduct(5,id);
            }
        });

        updateStock(products);
        addOrder(products);
        webClient = WebClient.create("http://localhost:8091");
        return webClient.post()
                .uri(uriBuilder -> uriBuilder.path("/shipping/ship")
                        .queryParam("pr", products)
                        .build())
                .retrieve()
                .bodyToFlux(Long.class);

    }

    public void updateStock(List<Long> ids){
        ids.forEach(id->{
            Product p = productRepository.findById(id).get();
            int newAmount = p.getStock().getAmount()-1;
            p.getStock().setAmount(newAmount);
            stockRepository.save(p.getStock());
        });
    }

    public void addOrder(List<Long> productsIds){
        double totalPrice= productsIds.stream().mapToDouble(id ->
                productRepository.findById(id).get().getPrice()).sum();
        System.out.println("priiiiiiiice "+totalPrice);

    }



}
