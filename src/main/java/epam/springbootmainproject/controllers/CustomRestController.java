package epam.springbootmainproject.controllers;

import epam.springbootmainproject.dao.CitiesDao;
import epam.springbootmainproject.dao.CountriesDao;
import epam.springbootmainproject.dao.SightsDao;
import epam.springbootmainproject.dao.UniversitiesDao;
import epam.springbootmainproject.models.City;
import epam.springbootmainproject.models.Country;
import epam.springbootmainproject.models.Sight;
import epam.springbootmainproject.models.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                             @RequestParam String history,
                             @RequestParam String nameCountry) {
        /*зі String робимо знову LocalDate*/
        LocalDate date = LocalDate.parse(dateOfCreation, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            System.out.println(date);
        City city = new City(nameCity, date, population, history);
        Country country = countriesDao.findByName(nameCountry);
        city.setCountry(country);
        citiesDao.save(city);
            System.out.println("Збережено: " + city);
    }

    @PostMapping("/updateCityAJAX")
    public void updateCityAJAX(@RequestBody City city) {
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

    @PostMapping("/updateCountyAJAX")
    public void updateCountyAJAX(@RequestBody Country country) {
        System.out.println(country);
        countriesDao.save(country);
        System.out.println("Збережено: " + country);
    }






    @PostMapping("/saveSightAJAX")
    public void saveSightAJAXform(@RequestBody Sight sight) {
        sightsDao.save(sight);
        System.out.println("Збережено: " + sight);
    }

    @PostMapping("/updateSightAJAX")
    public void updateSightAJAX(@RequestBody Sight sight) {
        sightsDao.save(sight);
        System.out.println("Збережено: " + sight);
    }





    @PostMapping("/saveUniversityAJAX")
    public void saveCountyAJAX(@RequestParam String nameUniversity,
                               @RequestParam String direction, /*витаягуємо стрінгу*/
                               @RequestParam String country,
                               @RequestParam String city,
                               @RequestParam String street,
                               @RequestParam String dateOfCreation,
                               @RequestParam String ownership,
                               @RequestParam String formOfTraining) {
        /*зі String робимо знову LocalDate*/
        LocalDate date = LocalDate.parse(dateOfCreation, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(date);

        University university = new University(nameUniversity,direction,country,city,street,date,ownership,formOfTraining);
        universitiesDao.save(university);
        System.out.println("Збережено: " + university);
    }




}
