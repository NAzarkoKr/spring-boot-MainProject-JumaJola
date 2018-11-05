package epam.springbootmainproject.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameCity;
    private int dateOfCreation;
    private int population;
    private String history;
//    private ArrayList<Sight> sightList;

    public City(String nameCity, int dateOfCreation, int population, String history) {
        this.nameCity = nameCity;
        this.dateOfCreation = dateOfCreation;
        this.population = population;
        this.history = history;
    }
}
