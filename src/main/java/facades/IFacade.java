package facades;

import entity.Person;

import java.util.List;
import java.util.Set;

public interface IFacade {

    List<Person> getAllPersons();

    Person getPersonInfoByPhoneNum(String phoneNum);

    Set<Person> getPersonsByHobby(String hobbyName);

    List<Person> getPersonsByZip(String zip);

    int personCountByHobby(String hobbyName);

    List<String> getAllZipcodes();

    Person createPerson(Person person);

    Person getPersonById(Long personId);

    Person editPerson(Person person, Long personId);

    boolean deletePerson(Long personId);


}
