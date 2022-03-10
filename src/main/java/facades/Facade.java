package facades;

import entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Facade implements IFacade{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");


    @Override
    public List<Person> getAllPersons() {
        EntityManager em = emf.createEntityManager();

        try{
            return em.createQuery("SELECT p FROM Person p",Person.class).getResultList();
        } finally {
            em.close();
        }

    }

    @Override
    public Person getPersonInfoByPhoneNum(String phoneNum) {
        return null;
    }

    @Override
    public List<Person> getPersonsByHobby(String hobbyName) {
        return null;
    }

    @Override
    public List<Person> getPersonsByZip(String zip) {
        return null;
    }

    @Override
    public int personCountByHobby(String hobbyName) {
        return 0;
    }

    @Override
    public List<String> getAllZipcodes() {
        return null;
    }

    @Override
    public void createPerson(Person person) {

    }

    @Override
    public void editPerson(Person person, Long personId) {

    }

    @Override
    public void deletePerson(Long personId) {

    }
}
