package epam.springbootmainproject.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

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
//    private List<Sight> sightList;

    public City(String nameCity, int dateOfCreation, int population, String history) {
        this.nameCity = nameCity;
        this.dateOfCreation = dateOfCreation;
        this.population = population;
        this.history = history;
    }
}
