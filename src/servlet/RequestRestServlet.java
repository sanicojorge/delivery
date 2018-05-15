package servlet;
import java.util.Calendar;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

import model.Client;
import model.Request;
import stateless.ClientService;
import stateless.RequestService;

import java.util.Collection;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

@Path("/{cli_id}/request")
public class RequestRestServlet {

  // inject a reference to the EmployeeService slsb
  @EJB RequestService serviceRequest;

  //mapea lista de pojo a JSON
  ObjectMapper mapper = new ObjectMapper();

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String findRequest(
      @PathParam("id") int id
    ) throws IOException {

    Request request = serviceRequest.findRequest(id);
    return mapper.writeValueAsString(request);
  }

	@POST
  @Consumes(MediaType.APPLICATION_JSON)
  public String addRequest(
      @PathParam("cli_id") int cliId,
      String request_json
    ) throws IOException {

      Request request = mapper.readValue(request_json, Request.class);
      Client cli = serviceRequest.addClientRequest(cliId, request);
      return mapper.writeValueAsString(cli);
  }

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  public String updateRequest(
      @PathParam("cli_id") int cliId,
      String request_json
    ) throws IOException {

      Request request = mapper.readValue(request_json, Request.class);
      Client cli = serviceRequest.updateClientRequest(cliId, request);
      return mapper.writeValueAsString(cli);
  }

  @DELETE
  @Path("/{request_id}")
  public String deleteRequest(
      @PathParam("cli_id") int cliId,
      @PathParam("request_id") int requestId
    ) throws IOException {

      Client cli = serviceRequest.removeClientRequest(cliId, requestId);
      return mapper.writeValueAsString(cli);
  }
}
