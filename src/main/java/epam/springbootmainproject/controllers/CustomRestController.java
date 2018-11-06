package epam.springbootmainproject.controllers;

import epam.springbootmainproject.dao.CitiesDao;
import epam.springbootmainproject.dao.CountriesDao;
import epam.springbootmainproject.dao.SightsDao;
import epam.springbootmainproject.dao.UniversitiesDao;
import epam.springbootmainproject.models.City;
import epam.springbootmainproject.models.Country;
import epam.springbootmainproject.models.Sight;
import epam.springbootmainproject.models.University;
import epam.springbootmainproject.models.enums.CountryContinentEnum;
import epam.springbootmainproject.models.enums.CountryPoliticalSystemEnum;
import epam.springbootmainproject.models.enums.UniversiryOwnershipEnum;
import epam.springbootmainproject.models.enums.UniversityFormOfTrainingEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
public class CustomRestController {

    @Autowired
    private CountriesDao countriesDao;

    @Autowired
    private CitiesDao citiesDao;

    @Autowired
    private SightsDao sightsDao;

    @Autowired
    private UniversitiesDao universitiesDao;



    @PostMapping("/saveCityAJAX")
    public void saveCityAJAX(@RequestParam String nameCity,
                             @RequestParam String dateOfCreation, /*витаягуємо стрінгу*/
                             @RequestParam int population,
                             @RequestParam String history) {
        /*зі String робимо знову LocalDate*/
        LocalDate date = LocalDate.parse(dateOfCreation, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(date);

        City city = new City(nameCity, date, population, history);
        citiesDao.save(city);
        System.out.println("Збережено: " + city);
    }

    @PostMapping("/saveCountyAJAX")
    public void saveCountyAJAX(@RequestParam String nameCountry,
                                   @RequestParam String dateOfCreation, /*витаягуємо стрінгу*/
                                   @RequestParam String politicalSystem,
                                   @RequestParam String continent,
                                   @RequestParam String capital,
                                   @RequestParam int square,
                                   @RequestParam int population) {
        /*зі String робимо знову LocalDate*/
        LocalDate date = LocalDate.parse(dateOfCreation, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(date);

        Country country = new Country(nameCountry, date, politicalSystem, continent, capital, square, population);
        countriesDao.save(country);
        System.out.println("Збережено: " + country);
    }

    @PostMapping("/saveUniversitiesAJAXform")
    public void saveUniversitiesAJAXform(
            @RequestParam String nameUniversity,
            @RequestParam int direction,
            @RequestParam String country,
            @RequestParam String city,
            @RequestParam String street,
            @RequestParam String dateOfCreation, /*витаягуємо стрінгу*/
            @RequestParam UniversiryOwnershipEnum ownership,
            @RequestParam UniversityFormOfTrainingEnum formOfTraining) {

        /*перетворюємо стрінгу знову в локал дату, щоб зберегти обєкт в БД(трабли зі збереженням)*/
        LocalDate date = LocalDate.parse(dateOfCreation, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(date);

        University universities = new University(nameUniversity, direction, country, city, street, date, ownership, formOfTraining);
        universitiesDao.save(universities);
        System.out.println("Збережено: " + universities);
    }

    @PostMapping("/updateUniversitiesAJAXform")
    public void updateUniversitiesAJAXform(@PathVariable int id,
                                           @RequestParam String nameUniversity,
                                           @RequestParam int direction,
                                           @RequestParam String country,
                                           @RequestParam String city,
                                           @RequestParam String street,
                                           @RequestParam String dateOfCreation, /*витаягуємо стрінгу*/
                                           @RequestParam UniversiryOwnershipEnum ownership,
                                           @RequestParam UniversityFormOfTrainingEnum formOfTraining) {

        University universities = universitiesDao.findById(id).get();
        LocalDate date = LocalDate.parse(dateOfCreation, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        universities.setId(id);
        universities.setNameUniversity(nameUniversity);
        universities.setDirection(direction);
        universities.setCountry(country);
        universities.setCity(city);
        universities.setStreet(street);
        universities.setDateOfCreation(date);
        universities.setOwnership(ownership);
        universities.setFormOfTraining(formOfTraining);
        ;
        universitiesDao.save(universities);
        System.out.println("Збережено: " + universities);
    }

    @PostMapping("/saveSightAJAX")
    public List<Sight> saveSightAJAXform(@RequestBody Sight sight) {
        sightsDao.save(sight);
        System.out.println("Збережено: " + sight);
        return sightsDao.findAll();
    }


}
