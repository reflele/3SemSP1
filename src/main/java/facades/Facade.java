package facades;

import entity.Hobby;
import entity.Person;
import entity.Phone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

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

        EntityManager em = emf.createEntityManager();
        Long foundId = 0L;

        try{
            TypedQuery<Phone> tq = em.createQuery("SELECT p FROM Phone p WHERE p.number = :phoneNum",Phone.class);
            tq.setParameter("phoneNum",phoneNum);
            foundId = tq.getSingleResult().getPerson().getId();

            return em.createQuery("SELECT p FROM Person p WHERE p.id =:foundId",Person.class)
                    .setParameter("foundId",foundId)
                    .getSingleResult();
        } finally {
            em.close();
        }

    }

    @Override
    public Set<Person> getPersonsByHobby(String hobbyName) {
        EntityManager em = emf.createEntityManager();
        Long foundHobbyId = 0L;


        try{

            TypedQuery<Hobby> tq = em.createQuery("SELECT h FROM Hobby h WHERE h.name = :hobbyName",Hobby.class);
            tq.setParameter("hobbyName",hobbyName);

            return tq.getSingleResult().getPersonSet();

        } finally {
            em.close();
        }

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
