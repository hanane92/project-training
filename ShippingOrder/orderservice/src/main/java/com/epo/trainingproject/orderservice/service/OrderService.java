package com.epo.trainingproject.orderservice.service;
import com.epo.trainingproject.orderservice.dao.OrderRepository;
import com.epo.trainingproject.orderservice.dao.ProductRepository;
import com.epo.trainingproject.orderservice.dao.StockRepository;
import com.epo.trainingproject.orderservice.entities.Orders;
import com.epo.trainingproject.orderservice.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.frequency;

@Service
@Transactional
public class OrderService implements IOrderService {

    public static final String SHIPPING_SERVICE_PATH ="http://localhost:8091";

    @Autowired
    private IProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private OrderRepository orderRepository;

    WebClient webClient;



    @Override
    public Flux<Long> makeOrder(List<Long> products) {

        Set<Long> newList = new HashSet<>(products);
        newList.forEach(id->{
            Product p = productService.checkProduct(id);
            int fr = frequency(products, id);
            if(fr>p.getStock().getAmount()){
                productService.addStocktoProduct(5,id);
            }
        });

        updateStock(products);
        addOrder(products);

        webClient = WebClient.create(SHIPPING_SERVICE_PATH);
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
        double totalPrice= productsIds.stream().mapToDouble(id -> productRepository.findById(id).get().getPrice()).sum();
        List<Product> products = new ArrayList<>();
        productsIds.forEach(id->{
            products.add(productRepository.findById(id).get());
        });
        orderRepository.save(new Orders(null,totalPrice,products));

    }

}
