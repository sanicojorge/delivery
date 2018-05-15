package stateless;

import java.util.Collection;
import java.util.function.Predicate;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Client;
import model.Request;

@Stateless
public class RequestServiceBean implements RequestService {
    @PersistenceContext(unitName="ClientService")
    protected EntityManager em;

    public void setEntityManager(EntityManager emLocal){
      em = emLocal;
    }

    public Request createRequest(Request request) {
        em.persist(request);
        return request;
    }

    public Request findRequest(int id){
      return em.find(Request.class, id);
    }

    public Collection<Request> findAllRequests() {
        Query query = em.createQuery("SELECT r FROM Request r");
        return (Collection<Request>) query.getResultList();
    }

    public Client addClientRequest(int cliId, Request request) {
        Client cli = em.find(Client.class, cliId);

        em.persist(request);
        cli.addRequest(request);
        em.persist(cli);

        return cli;
    }

    public Client removeClientRequest(int id, int request_id){
        Client cli = em.find(Client.class, id);

        if (cli == null){
          return null;
        }

        Collection<Request> requests = cli.getRequests();
        Predicate<Request> requestP = p -> p.getId() == request_id;
        requests.removeIf(requestP);

        em.persist(cli);
        return cli;
    }

    public Client updateClientRequest(int cliId, Request request) {
        Client cli = em.find(Client.class, cliId);

        if (cli == null){
          return null;
        }

        if(cli.getRequests().removeIf(p -> p.getId() == request.getId())){
          em.persist(request);
          cli.addRequest(request);
          em.persist(cli);
          return cli;
        }

        return null;
    }

}
