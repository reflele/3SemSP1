package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    Address address;

    public void addAddress(Address address){
        address.addPerson(this);
        this.address = address;
    }


    @OneToMany(mappedBy = "person", cascade = CascadeType.REMOVE)
    private Set<Phone> phoneSet = new HashSet<>();

    public void addPhone(Phone phone){
        phoneSet.add(phone);
        phone.addPerson(this);
    }

    @ManyToMany(mappedBy ="personSet")
    private Set<Hobby> hobbySet = new HashSet<>();

    public Set<Hobby> getHobbySet() {
        return hobbySet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addHobby(Hobby hobby) {
        this.hobbySet.add(hobby);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(email, person.email) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(address, person.address) && Objects.equals(phoneSet, person.phoneSet) && Objects.equals(hobbySet, person.hobbySet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName, address, phoneSet, hobbySet);
    }
}
