package com.epo.trainingproject.orderservice.service;


import com.epo.trainingproject.orderservice.entities.Product;

public interface IProductService {
    public void registerProduct(Product product);
    public Product checkProduct(Long product_id);
    public void addStocktoProduct(int quantity,Long product_id);

}
