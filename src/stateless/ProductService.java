package stateless;

import java.util.Collection;

import javax.persistence.EntityManager;

import model.Product;

public interface ProductService {
    public void setEntityManager(EntityManager em);
    public Product createProduct(Product prod);
    public Product removeProduct(int id);
    public Product updateProduct(Product prod);
    public Product findProduct(int id);
    public Collection<Product> findAllProducts();
}
