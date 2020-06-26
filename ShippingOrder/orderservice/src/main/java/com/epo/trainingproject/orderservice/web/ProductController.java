package com.epo.trainingproject.orderservice.web;

import com.epo.trainingproject.orderservice.entities.Product;
import com.epo.trainingproject.orderservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
   private IProductService productService;


    @RequestMapping(value = "/product/register",method = RequestMethod.POST)
    public String registerProduct(Model model, @RequestBody Product product, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) System.out.println("error detected");
        productService.
                registerProduct(product);
        return "product added";
    }

    @RequestMapping(value = "/product/add-stock",method = RequestMethod.PUT)
    public void stockProdAdd(@RequestParam(name ="id" ) Long id,
                             @RequestParam(name = "quantity") int quantity) throws Exception {

        if(quantity <= 0) throw new Exception("Quantity should be a positive value above zero");
        productService.addStocktoProduct(quantity,id);
    }


}
