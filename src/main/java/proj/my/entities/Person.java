package proj.my.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "persons")
@Getter
@Setter
@ToString
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
    private String cityOfLiving;


}
