package com.epo.trainingproject.orderservice.web;

import com.epo.trainingproject.orderservice.service.OrderService;
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
