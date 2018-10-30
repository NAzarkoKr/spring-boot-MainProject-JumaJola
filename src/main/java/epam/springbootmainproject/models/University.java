package epam.springbootmainproject.models;

import epam.springbootmainproject.models.enums.UniversiryOwnershipEnum;
import epam.springbootmainproject.models.enums.UniversityFormOfTrainingEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameUniversity;
    private int direction;
    private String country;
    private String city;
    private String street;
    private int dateOfCreation;
    @Enumerated(EnumType.STRING)
    private UniversiryOwnershipEnum ownership;
    @Enumerated(EnumType.STRING)
    private UniversityFormOfTrainingEnum formOfTraining;

    public University(String nameUniversity, int direction, String country, String city, String street, int dateOfCreation, UniversiryOwnershipEnum ownership, UniversityFormOfTrainingEnum formOfTraining) {
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
