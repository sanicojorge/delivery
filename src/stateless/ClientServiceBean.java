package stateless;

import java.util.Collection;

import javax.annotation.Resource;
import javax.ejb.Stateless;
// import javax.jms.Queue;
// import javax.jms.QueueConnectionFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Client;

@Stateless
public class ClientServiceBean implements ClientService {
    @PersistenceContext(unitName="ClientService")
    protected EntityManager em;

    //@Resource(mappedName="destinationQueue") Queue destinationQueue;
    //@Resource(mappedName="factory") QueueConnectionFactory factory;

    public void setEntityManager(EntityManager emLocal){
      em = emLocal;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    // public Employee createEmployee(int id, String name, long salary) {
    //     Employee emp = new Employee(id);
    //     emp.setName(name);
    //     emp.setSalary(salary);
    //     getEntityManager().persist(emp);
    //     return emp;
    // }

    public Client createClient(Client cli) {
        getEntityManager().persist(cli);
        return cli;
    }

    public Client removeClient(int id) {
        Client cli = findClient(id);
        if (cli != null) {
            getEntityManager().remove(cli);
            return cli;
        } else return null;

    }

    public Client changeClientCuil(int id, String newCuil) {
        Client cli = findClient(id);
        if (cli != null) {
            cli.setCuil(newCuil);
        }
        return cli;
    }

    public Client findClient(int id) {
        return getEntityManager().find(Client.class, id);
    }

    public Collection<Client> findAllClients() {
        Query query = getEntityManager().createQuery("SELECT e FROM Client e");
        return (Collection<Client>) query.getResultList();
    }
}
