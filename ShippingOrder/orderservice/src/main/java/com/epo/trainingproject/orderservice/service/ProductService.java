package com.epo.trainingproject.orderservice.service;
import com.epo.trainingproject.orderservice.dao.OrderRepository;
import com.epo.trainingproject.orderservice.dao.ProductRepository;
import com.epo.trainingproject.orderservice.dao.ProductTypeRepository;
import com.epo.trainingproject.orderservice.dao.StockRepository;
import com.epo.trainingproject.orderservice.entities.Product;
import com.epo.trainingproject.orderservice.entities.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;


@Service
@Transactional
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public void registerProduct(Product product) {

        productRepository.save(product);
    }

    @Override
    public Product checkProduct(Long product_id) {

        Product  product = productRepository.findById(product_id).orElseThrow(()->new NoSuchElementException());


        return product;
    }

    @Override
    public void addStocktoProduct(int quantity, Long product_id) {

        Product product = checkProduct(product_id);
        Stock stock = product.getStock();
        stock.setAmount(stock.getAmount()+quantity);
        stockRepository.save(stock);
        productRepository.save(product);
    }
}
