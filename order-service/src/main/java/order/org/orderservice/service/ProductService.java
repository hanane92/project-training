package order.org.orderservice.service;

import order.org.orderservice.dao.OrderRepository;
import order.org.orderservice.dao.ProductRepository;
import order.org.orderservice.dao.ProductTypeRepository;
import order.org.orderservice.dao.StockRepository;
import order.org.orderservice.entities.Product;
import order.org.orderservice.entities.Stock;
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
    private OrderRepository orderRepository;
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
