package stateless;

import java.util.Collection;

import javax.persistence.EntityManager;

import model.Client;

public interface ClientService {
    public void setEntityManager(EntityManager em);
    public Client createClient(Client cli);
    public Client removeClient(int id);
    public Client changeClientCuil(int id, String newCuil);
    public Client findClient(int id);
    public Collection<Client> findAllClients();
}
