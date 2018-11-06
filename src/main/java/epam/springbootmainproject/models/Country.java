package epam.springbootmainproject.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameCountry;
    private LocalDate dateOfCreation;
    private String politicalSystem;
    private String continent;
    private String capital;
    private int square;
    private int population;
//    private ArrayList<University> universitiesList = new ArrayList<>();
//    private ArrayList<City> cityList;

    public Country(String nameCountry, LocalDate dateOfCreation, String politicalSystem, String continent, String capital, int square, int population) {
        this.nameCountry = nameCountry;
        this.dateOfCreation = dateOfCreation;
        this.politicalSystem = politicalSystem;
        this.continent = continent;
        this.capital = capital;
        this.square = square;
        this.population = population;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setPoliticalSystem(String politicalSystem) {
        this.politicalSystem = politicalSystem;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setId(int id) {
        this.id = id;
    }
}
