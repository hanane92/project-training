package com.epo.trainingproject.orderservice;

import com.epo.trainingproject.orderservice.dao.OrderRepository;
import com.epo.trainingproject.orderservice.dao.ProductRepository;
import com.epo.trainingproject.orderservice.dao.ProductTypeRepository;
import com.epo.trainingproject.orderservice.dao.StockRepository;
import com.epo.trainingproject.orderservice.entities.Orders;
import com.epo.trainingproject.orderservice.entities.Product;
import com.epo.trainingproject.orderservice.entities.ProductType;
import com.epo.trainingproject.orderservice.entities.Stock;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@SpringBootApplication
public class OrderserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository,
                            OrderRepository orderRepository,
                            ProductTypeRepository productTypeRepository,
                            StockRepository stockRepository,
                            RepositoryRestConfiguration repositoryRestConfiguration) {

        return args -> {
            ProductType type1 = productTypeRepository.save(new ProductType(null, "type1"));
            ProductType type2 = productTypeRepository.save(new ProductType(null, "type2"));

            Stock s1 = stockRepository.save(new Stock(null, 1, null));
            Stock s2 = stockRepository.save(new Stock(null, 90, null));
            Stock s3 = stockRepository.save(new Stock(null, 18, null));

            Product p1 = productRepository.save(new Product(null, "p1", "laptop", 9087, s1, type1));
            Product p2 = productRepository.save(new Product(null, "p2", "camera", 6889, s2, type2));
            Product p3 = productRepository.save(new Product(null, "p3", "iphone", 6889, s3, type2));


            Orders orderr1 = new Orders(null, 9876, null);
            Orders orderr2 = new Orders(null, 5000, null);



            orderr1.setProducts(asList(p1, p2));
            orderr2.setProducts(asList(p1, p2, p3));
            orderRepository.save(orderr1);
            orderRepository.save(orderr2);



        };
    }
        }
