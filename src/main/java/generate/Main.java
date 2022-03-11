package generate;

import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
    }

    public static void generate(EntityManagerFactory emf){
        EntityManager em = emf.createEntityManager();

        try {
            Person person1 = new Person("rabee@hotmail.dk","Rabee","Abla");
            Person person2 = new Person("peter@live.dk","Peter","Nedergaard");
            Person person3 = new Person("mo@yahoo.dk","Mohammed","Gheith");

            Hobby hobby1 = new Hobby("Parkour", "Feels like spiderman");
            Hobby hobby2 = new Hobby("Ping pong","Inspired by Forrest Gump");

            Phone phone1 = new Phone("54843585","Nokia 3310i");
            Phone phone2 = new Phone("54853846","Nokia 6610");

            Address address1 = new Address("Rosenlundsvej 63", "Three plus five");
            Address address2 = new Address("Carlos Allé 52", "Sixteen plus nine");

            CityInfo cityInfo1 = new CityInfo("2791","Dragør");
            CityInfo cityInfo2 = new CityInfo("2000","København K");

            em.getTransaction().begin();

            em.persist(person1);
            em.persist(person2);
            em.persist(person3);

            em.persist(hobby1);
            em.persist(hobby2);

            em.persist(phone1);
            em.persist(phone2);

            em.persist(address1);
            em.persist(address2);

            em.persist(cityInfo1);
            em.persist(cityInfo2);

            hobby1.addPerson(person1);
            hobby1.addPerson(person2);
            hobby2.addPerson(person1);

            person2.addPhone(phone1);
            person1.addPhone(phone2);

            person3.addAddress(address1);
            person2.addAddress(address2);
            person1.addAddress(address1);

            address1.addCityInfo(cityInfo1);
            address2.addCityInfo(cityInfo2);




            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }
}
