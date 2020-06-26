package com.epo.trainingproject.shippingservice.controller;

import com.epo.trainingproject.shippingservice.service.IServicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShippingController {

    @Autowired
    private IServicee iServicee;

    @PostMapping("shipping/ship")
    public void getPro(@RequestParam(name = "pr") List<Long> productsIds){

        iServicee.calculateTag(productsIds);

    }





}
