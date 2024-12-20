package org.example.demo_jpa_repositories.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Getter;
import lombok.Setter;
import org.example.demo_jpa_repositories.entity.PersonId;

@Entity
@IdClass(PersonId.class)
@Getter
@Setter
public class Persons {

    @Id
    private String name;

    @Id
    private String surname;

    @Id
    private int age;

    private String phoneNumber;

    private String cityOfResidence;

    public Persons() {
    }

    public Persons(String name, String surname, int age, String phoneNumber, String cityOfResidence) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.cityOfResidence = cityOfResidence;
    }
}
