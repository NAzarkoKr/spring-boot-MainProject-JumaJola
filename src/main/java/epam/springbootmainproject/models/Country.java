package epam.springbootmainproject.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
//    private List<City> cityList;

    public Country(String nameCountry, LocalDate dateOfCreation, String politicalSystem, String continent, String capital, int square, int population) {
        this.nameCountry = nameCountry;
        this.dateOfCreation = dateOfCreation;
        this.politicalSystem = politicalSystem;
        this.continent = continent;
        this.capital = capital;
        this.square = square;
        this.population = population;
    }
}
