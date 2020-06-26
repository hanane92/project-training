package order.org.orderservice;

import order.org.orderservice.dao.OrderRepository;
import order.org.orderservice.dao.ProductRepository;
import order.org.orderservice.dao.ProductTypeRepository;
import order.org.orderservice.dao.StockRepository;
import order.org.orderservice.entities.Ordere;
import order.org.orderservice.entities.Product;
import order.org.orderservice.entities.Product_types;
import order.org.orderservice.entities.Stock;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

@SpringBootApplication
public class OrderServiceApplication  {


	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}



	@Bean
	CommandLineRunner start(ProductRepository productRepository,
							OrderRepository  orderRepository,
							ProductTypeRepository productTypeRepository,
							StockRepository stockRepository,
							RepositoryRestConfiguration repositoryRestConfiguration){

		return args->{
            Product_types type1 = productTypeRepository.save(new Product_types(null,"type1"));
			Product_types type2 =  productTypeRepository.save(new Product_types(null,"type2"));

			Stock s1 = stockRepository.save(new Stock(null,1,null));
			Stock s2 = stockRepository.save(new Stock(null,90,null));
			Stock s3 = stockRepository.save(new Stock(null,18,null));

			Product p1= productRepository.save(new Product(null,"p1","laptop",9087,s1,type1));
			Product p2 = productRepository.save(new Product(null,"p2","camera",6889,s2,type2));
			Product p3 = productRepository.save(new Product(null,"p3","iphone",6889,s3,type2));




			Ordere orderr1 = new Ordere(null,9876,null);
			Ordere orderr2 = new Ordere(null,5000,null);

			orderr1.setProducts(asList(p1,p2).stream().collect(Collectors.toSet()));
			orderr2.setProducts(asList(p1,p2,p3).stream().collect(Collectors.toSet()));
			orderRepository.save(orderr1);
			orderRepository.save(orderr2);














		};
	}
}
