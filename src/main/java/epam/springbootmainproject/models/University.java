package epam.springbootmainproject.models;

import epam.springbootmainproject.models.enums.UniversiryOwnershipEnum;
import epam.springbootmainproject.models.enums.UniversityFormOfTrainingEnum;
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
    private int direction;
    private String country;
    private String city;
    private String street;
    private LocalDate dateOfCreation;
    @Enumerated(EnumType.STRING)
    private UniversiryOwnershipEnum ownership;
    @Enumerated(EnumType.STRING)
    private UniversityFormOfTrainingEnum formOfTraining;

    public University(String nameUniversity, int direction, String country, String city, String street, LocalDate  dateOfCreation, UniversiryOwnershipEnum ownership, UniversityFormOfTrainingEnum formOfTraining) {
        this.nameUniversity = nameUniversity;
        this.direction = direction;
        this.country = country;
        this.city = city;
        this.street = street;
        this.dateOfCreation = dateOfCreation;
        this.ownership = ownership;
        this.formOfTraining = formOfTraining;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameUniversity(String nameUniversity) {
        this.nameUniversity = nameUniversity;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setOwnership(UniversiryOwnershipEnum ownership) {
        this.ownership = ownership;
    }

    public void setFormOfTraining(UniversityFormOfTrainingEnum formOfTraining) {
        this.formOfTraining = formOfTraining;
    }


}
