package entity;

import javax.persistence.*;
import java.util.HashSet;
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
    Address address;

    public void addAddress(Address address){
        address.addPerson(this);
        this.address = address;
    }


    @OneToMany
    private Set<Phone> phoneSet = new HashSet<>();

    public void addPhone(Phone phone){
        phoneSet.add(phone);
        phone.addPerson(this);
    }

    @ManyToMany(mappedBy ="personSet")
    private Set<Hobby> hobbySet = new HashSet<>();

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
}
