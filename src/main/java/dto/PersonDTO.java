package dto;

import entity.Address;
import entity.Hobby;
import entity.Person;
import entity.Phone;

import java.util.HashSet;
import java.util.Set;

public class PersonDTO {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    AddressDTO addressDTO;
    private Set<String> phoneDTOSet = new HashSet<>();
    private Set<HobbyDTO> hobbyDTOSet = new HashSet<>();

    public PersonDTO(Long id, String email, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonDTO(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.email = person.getEmail();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.addressDTO = new AddressDTO(person.getAddress());

        for (Phone p : person.getPhoneSet()) {
            this.phoneDTOSet.add("id:" + p.getId() + " number:" + p.getNumber() + " description:" + p.getDescription());
        }
    }
}
