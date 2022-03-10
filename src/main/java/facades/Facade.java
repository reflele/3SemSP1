package facades;

import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
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
        EntityManager em = emf.createEntityManager();

        Long cityInfoId = 0L;
        List<Person> listOfPersons = new ArrayList<>();

        try{

            TypedQuery<CityInfo> tq = em.createQuery("SELECT c FROM CityInfo c WHERE c.zipCode = :zip",CityInfo.class);
            tq.setParameter("zip",zip);

            for (Address a : tq.getSingleResult().getAddressSet()) {
                for (Person p : a.getPersonSet()) {
                    listOfPersons.add(p);
                }
            }

            return listOfPersons;

        } finally {
            em.close();
        }


    }

    @Override
    public int personCountByHobby(String hobbyName) {
        EntityManager em = emf.createEntityManager();

        Long hobbyId = 0L;
        int count = 0;

        try{

            TypedQuery<Hobby> tq = em.createQuery("SELECT h FROM Hobby h WHERE h.name = :hobbyName",Hobby.class);
            tq.setParameter("hobbyName",hobbyName);

            hobbyId = tq.getSingleResult().getId();

            for (Person p : getAllPersons()) {
                for (Hobby h : p.getHobbySet()) {
                    if (h.getId() == hobbyId){
                        count ++;
                    }
                }
            }

            return count;

        } finally {
            em.close();
        }

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
