package servlet;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import model.Client;
import stateless.ClientService;

import java.util.Collection;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

@Path("/clients")
public class ClientRestServlet {

  // inject a reference to the EmployeeService slsb
  @EJB ClientService service;

  //mapea lista de pojo a JSON
  ObjectMapper mapper = new ObjectMapper();

	@GET
  @Produces(MediaType.APPLICATION_JSON)
	public String findAllClients() throws IOException {
		Collection<Client> emps = service.findAllClients();
    return mapper.writeValueAsString(emps);
	}

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String findClient(@PathParam("id") int id) throws IOException {
    Client cli = service.findClient(id);
    return mapper.writeValueAsString(cli);
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public String createClient(String json) throws IOException {
    Client cli = mapper.readValue(json, Client.class);
    cli = service.createClient(cli);
    return mapper.writeValueAsString(cli);
  }


  @DELETE
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String removeClient(@PathParam("id") int id) throws IOException {
    Client cli = service.removeClient(id);
    return mapper.writeValueAsString(cli);
  }

  @PUT
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String changeClientCuil(@PathParam("id") int id, @QueryParam("cuil") String newCuil) throws IOException {
      Client cli = service.changeClientCuil(id,newCuil);
      return mapper.writeValueAsString(cli);
  }
}
