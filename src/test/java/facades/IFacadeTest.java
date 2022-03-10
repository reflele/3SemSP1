package facades;

import entity.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;
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
        String expected = "1";
        String actual = facade.getPersonInfoByPhoneNum("54853846").getId().toString();

        assertEquals(expected,actual);
    }

    @Test
    void getPersonsByHobby() {
        List<Long> expected = new ArrayList<>();
        List<Long> actual = new ArrayList<>();

        expected.add(2L);
        expected.add(1L);

        for (Person p : facade.getPersonsByHobby("Parkour")) {
            actual.add(p.getId());
        }

        assertEquals(expected,actual);
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