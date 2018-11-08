package epam.springbootmainproject.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String nameCountry;
    private LocalDate dateOfCreation;
    private String politicalSystem;
    private String continent;
    private String capital;
    private int square;
    private int population;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "country")
    private List<City> cityList = new ArrayList<>();

    public Country() {
    }

    public Country(String nameCountry, LocalDate dateOfCreation, String politicalSystem, String continent, String capital, int square, int population) {
        this.nameCountry = nameCountry;
        this.dateOfCreation = dateOfCreation;
        this.politicalSystem = politicalSystem;
        this.continent = continent;
        this.capital = capital;
        this.square = square;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getPoliticalSystem() {
        return politicalSystem;
    }

    public void setPoliticalSystem(String politicalSystem) {
        this.politicalSystem = politicalSystem;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", nameCountry='" + nameCountry + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                ", politicalSystem='" + politicalSystem + '\'' +
                ", continent='" + continent + '\'' +
                ", capital='" + capital + '\'' +
                ", square=" + square +
                ", population=" + population +
//                ", cityList=" + cityList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return getId() == country.getId() &&
                getSquare() == country.getSquare() &&
                getPopulation() == country.getPopulation() &&
                Objects.equals(getNameCountry(), country.getNameCountry()) &&
                Objects.equals(getDateOfCreation(), country.getDateOfCreation()) &&
                Objects.equals(getPoliticalSystem(), country.getPoliticalSystem()) &&
                Objects.equals(getContinent(), country.getContinent()) &&
                Objects.equals(getCapital(), country.getCapital()) &&
                Objects.equals(getCityList(), country.getCityList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNameCountry(), getDateOfCreation(), getPoliticalSystem(), getContinent(), getCapital(), getSquare(), getPopulation(), getCityList());
    }

}
