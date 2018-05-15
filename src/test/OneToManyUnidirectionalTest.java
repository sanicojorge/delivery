import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;

import model.Employee;
import stateless.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;

public class OneToManyUnidirectionalTest {
  public static EmployeeService serviceEmployee;
  public static PhoneService servicePhone;
  protected static EntityManager em;
  protected static EntityManagerFactory emf;

  @BeforeClass
  public static void preTest(){
    emf = Persistence.createEntityManagerFactory("EmployeeService");
    em = emf.createEntityManager();
    serviceEmployee = new EmployeeServiceBean();
    serviceEmployee.setEntityManager(em);
    servicePhone = new PhoneServiceBean();
    servicePhone.setEntityManager(em);

  }

  @Test
  public void createAndCountTest() {
    Collection <Employee> emps = serviceEmployee.findAllEmployees();
    int size = emps.size();
    Employee emp;

    em.getTransaction().begin();

    emp = new Employee();
    emp.setName("uno");
    emp.setSalary(1000);
    serviceEmployee.createEmployee(emp);

    emp = new Employee();
    emp.setName("dos");
    emp.setSalary(2000);
    serviceEmployee.createEmployee(emp);

    emp = new Employee();
    emp.setName("tres");
    emp.setSalary(3000);
    serviceEmployee.createEmployee(emp);

    emp = new Employee();
    emp.setName("cuatro");
    emp.setSalary(4000);
    serviceEmployee.createEmployee(emp);

    emp = new Employee();
    emp.setName("cinco");
    emp.setSalary(5000);
    serviceEmployee.createEmployee(emp);

    em.getTransaction().commit();

    emps = serviceEmployee.findAllEmployees();
    assertEquals("el tamaño de la colección no es igual a la cantidad de inserts", emps.size(),size+5);
  }

  @AfterClass
  public static void postTest() {
    // elimina todos los datos de Employee
    //em.getTransaction().begin();
    //service.removeEmployee(1);
    //em.getTransaction().commit();

    // Cierra las conexiones
    em.close();
    emf.close();
  }
}
