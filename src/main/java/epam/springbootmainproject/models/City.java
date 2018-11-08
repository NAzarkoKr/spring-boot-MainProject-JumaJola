package epam.springbootmainproject.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String nameCity;
    private LocalDate dateOfCreation;
    private int population;
    private String history;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Country country;

    public City() {
    }

    public City(String nameCity, LocalDate dateOfCreation, int population, String history) {
        this.nameCity = nameCity;
        this.dateOfCreation = dateOfCreation;
        this.population = population;
        this.history = history;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", nameCity='" + nameCity + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                ", population=" + population +
                ", history='" + history + '\'' +
//                ", country=" + country +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return getId() == city.getId() &&
                getPopulation() == city.getPopulation() &&
                Objects.equals(getNameCity(), city.getNameCity()) &&
                Objects.equals(getDateOfCreation(), city.getDateOfCreation()) &&
                Objects.equals(getHistory(), city.getHistory()) &&
                Objects.equals(getCountry(), city.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNameCity(), getDateOfCreation(), getPopulation(), getHistory(), getCountry());
    }
}
