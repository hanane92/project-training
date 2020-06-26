package com.epo.trainingproject.shippingservice.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MyService implements IServicee {


    @Override
    public void calculateTag(List<Long> productsIds) {

        Long concatenatedResult = Long.parseLong(productsIds.toString().replaceAll("\\D",""));
        log.info("Concatenated Result is : "+concatenatedResult);
        int hashValue = concatenatedResult.hashCode();
        log.info("Result hashed is : "+hashValue);


    }
}
