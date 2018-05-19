package stateless;

import java.util.Collection;
import java.util.function.Predicate;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Product;
import model.Request;

@Stateless
public class ProductServiceBean implements ProductService {
    @PersistenceContext(unitName="ClientService")
    protected EntityManager em;

    public void setEntityManager(EntityManager emLocal){
      em = emLocal;
    }

    public Product createProduct(Product product) {
        em.persist(product);
        return product;
    }

    public Product findProduct(int id){
      return em.find(Product.class, id);
    }

    public Collection<Product> findAllProducts() {
        Query query = em.createQuery("SELECT p FROM Product p");
        return (Collection<Product>) query.getResultList();
    }

    public Product addProduct(Product product) {
       
        em.persist(product);
        return product;
    }
    public Product removeProduct(int id ){
        Product prod = em.find(Product.class, id);
       
        if (prod != null) {
            em.remove(prod);
                        
            return prod;
        } else return null;
    }

    public Product updateProduct(Product product) {
       
       Product prod = em.find(Product.class, product.getId());
       prod.setDescription(product.getDescription());
       prod.setName(product.getName());
       prod.setStock(product.getStock());
       prod.setUnit(product.getUnit());
       prod.SetPrice(product.getPrice());
          
        em.persist(prod);
        return prod;
        
    }

}
