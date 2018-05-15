package stateless;

import java.util.Collection;
import javax.persistence.EntityManager;

import model.Client;
import model.Request;

public interface RequestService {
    public void setEntityManager(EntityManager emLocal);

    public Request createRequest(Request request);
    public Collection<Request> findAllRequests();

    public Request findRequest(int id);
    public Client removeClientRequest(int id, int request_id);
    public Client addClientRequest(int cliId, Request request);
    public Client updateClientRequest(int cliId, Request request);
}
