package facades;

import entity.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IFacadeTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    Facade facade;

    @BeforeEach
    void setUp() {
        facade = new Facade();
    }

    @AfterEach
    void tearDown() {
    }



    @Test
    void getAllPersons() {
        EntityManager em = emf.createEntityManager();

        int expected = 3;
        int actual = facade.getAllPersons().size();

        assertEquals(expected,actual);
    }

    @Test
    void getPersonInfoByPhoneNum() {
    }

    @Test
    void getPersonsByHobby() {
    }

    @Test
    void getPersonsByZip() {
    }

    @Test
    void personCountByHobby() {
    }

    @Test
    void getAllZipcodes() {
    }

    @Test
    void createPerson() {
    }

    @Test
    void editPerson() {
    }

    @Test
    void deletePerson() {
    }
}