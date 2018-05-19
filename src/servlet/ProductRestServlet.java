package servlet;


import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import model.Product;
import stateless.ProductService;

import java.util.Collection;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

@Path("/products")
public class ProductRestServlet {

  // inject a reference to the EmployeeService slsb
  @EJB ProductService service;

  //mapea lista de pojo a JSON
  ObjectMapper mapper = new ObjectMapper();

	@GET
  @Produces(MediaType.APPLICATION_JSON)
	public String findAllProducts() throws IOException {
    Collection<Product> prods = service.findAllProducts();
        return mapper.writeValueAsString(prods);
	}

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String findProduct(@PathParam("id") int id) throws IOException {
    Product prod = service.findProduct(id);

    return mapper.writeValueAsString(prod);
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public String createProduct(String json) throws IOException {
    
    Product product = mapper.readValue(json, Product.class);
    product = service.createProduct(product);
    return mapper.writeValueAsString(product);
  }


  @DELETE
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String removeProduct(@PathParam("id") int id) throws IOException {
    Product prod = service.removeProduct(id);
    return mapper.writeValueAsString(prod);
  }

 
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  public String updateProduct( String json) throws IOException {
      
      Product product = mapper.readValue(json, Product.class);
      product = service.updateProduct( product);
      
      return mapper.writeValueAsString(product);
  }
}
