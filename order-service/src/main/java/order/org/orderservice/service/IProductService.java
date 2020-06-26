package order.org.orderservice.service;

import order.org.orderservice.entities.Product;
import order.org.orderservice.entities.Stock;

public interface IProductService {
    public void registerProduct(Product product);
    public Product checkProduct(Long product_id);
    public void addStocktoProduct(int quantity,Long product_id);

}
