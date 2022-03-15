package facades;

import generate.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class IFacadeDTOTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("putest");
    EntityManager em;
    FacadeDTO facadeDTO = new FacadeDTO("putest");

    @BeforeEach
    void setUp() {
        em = emf.createEntityManager();
        Main.generate(emf);
    }

    @AfterEach
    void tearDown() {
        //drop all tables
    }

    @Test
    void getAllPersons() {
    int expected = 3;
    int actual = facadeDTO.getAllPersons().size();

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
    void getPersonById() {
    }

    @Test
    void editPerson() {
    }

    @Test
    void deletePerson() {
    }
}