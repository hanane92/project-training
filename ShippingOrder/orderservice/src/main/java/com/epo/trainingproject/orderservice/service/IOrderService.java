package com.epo.trainingproject.orderservice.service;

import reactor.core.publisher.Flux;

import java.util.List;

public interface IOrderService {

    public Flux<Long> makeOrder(List<Long> products);
}
