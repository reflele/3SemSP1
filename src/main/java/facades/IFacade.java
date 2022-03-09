package facades;

import entity.Person;

import java.util.List;

public interface IFacade {

    List<Person> getAllPersons();

    Person getPersonInfoByPhoneNum(String phoneNum);

    List<Person> getPersonsByHobby(String hobbyName);

    List<Person> getPersonsByZip(String zip);

    int personCountByHobby(String hobbyName);

    List<String> getAllZipcodes();

    void createPerson(Person person);

    void editPerson(Person person, Long personId);

    void deletePerson(Long personId);


}
