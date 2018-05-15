package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Client {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="cliId")
    private int id;
    private String name;
    private String cuil;

    @OneToMany
    @JoinTable(name="CLI_REQUEST",
          joinColumns=@JoinColumn(name="cliId"),
          inverseJoinColumns=@JoinColumn(name="requestId"))
    private Collection<Request> request;

    public Client() {
        request = new ArrayList<Request>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public void addRequest(Request request) {
        if (!getRequests().contains(request)) {
            getRequests().add(request);
        }
    }

    public Collection<Request> getRequests() {
        return request;
    }

    public String toString() {
        return "Cliente id: " + getId() + " nombre: " + getName() +
               " con " + getRequests().size() + " pedidos";
    }
}
