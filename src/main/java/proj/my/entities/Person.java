package proj.my.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "persons")
@Getter
@Setter
@ToString
@IdClass(value = PersonID.class)
public class Person {
    @Id
    @Column
    private String name;
    @Id
    @Column
    private String surname;
    @Id
    @Column
    private int age;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "city_of_living")
    private String city;


}
