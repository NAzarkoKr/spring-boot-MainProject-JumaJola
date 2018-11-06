package epam.springbootmainproject.models;

import lombok.Data;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameUniversity;
    private String direction;
    private String country;
    private String city;
    private String street;
    private LocalDate dateOfCreation;
    private String ownership;
    private String formOfTraining;

    public University(String nameUniversity, String direction, String country, String city, String street, LocalDate dateOfCreation, String ownership, String formOfTraining) {
        this.nameUniversity = nameUniversity;
        this.direction = direction;
        this.country = country;
        this.city = city;
        this.street = street;
        this.dateOfCreation = dateOfCreation;
        this.ownership = ownership;
        this.formOfTraining = formOfTraining;
    }
}
