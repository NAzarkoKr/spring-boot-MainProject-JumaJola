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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        LocalDate date = LocalDate.parse(dateOfCreation, DateTimeFormatter.ofPattern("yyyy-MM-dd")); /*зі String робимо знову LocalDate*/
        City city = new City(nameCity, date, population, history);
        Country country = countriesDao.findByName(nameCountry);

        city.setCountry(country);
        if (country!=null){
            citiesDao.save(city);
            System.out.println("Збережено: " + city);
        }else{
            System.out.println("Cheater Detected!");
        }

    }

    @PostMapping("/updateCityAJAX{nameCountry}")
    public void updateCityAJAX(@RequestBody City city,
                               @PathVariable String nameCountry) {
        Country country = countriesDao.findByName(nameCountry);
        city.setCountry(country);
        if (country!=null){
            citiesDao.save(city);
            System.out.println("Оновлено: " + city);
        }else{
            System.out.println("Cheater Detected!");
        }
    }








    @PostMapping("/saveCountyAJAX")
    public void saveCountyAJAX(@RequestParam String nameCountry,
                               @RequestParam String dateOfCreation,
                               @RequestParam String politicalSystem,
                               @RequestParam String continent,
                               @RequestParam String capital,
                               @RequestParam int square,
                               @RequestParam int population) {
        LocalDate date = LocalDate.parse(dateOfCreation, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(date);
        Country country = new Country(nameCountry, date, politicalSystem, continent, capital, square, population);
        countriesDao.save(country);
        System.out.println("Збережено: " + country);
    }

    @PostMapping("/updateCountyAJAX")
    public void updateCountyAJAX(@RequestBody Country country) {
        countriesDao.save(country);
        System.out.println("Оновлено country: " + country);
    }
    @GetMapping("/SearchCountryAJAX{nameCountry}")
    public String SearchCountryAJAX(@PathVariable String nameCountry,
                                    Model model){

        Country countryList = countriesDao.findByName(nameCountry);
        model.addAttribute("countryList", countryList);
        System.out.println(nameCountry);
        System.out.println(countriesDao.findByName(nameCountry));
        return "countries/search";
    }










    @PostMapping("/saveSightAJAX{nameCity}")
    public void saveSightAJAXform(@RequestBody Sight sight,
                                  @PathVariable String nameCity) {
        City city = citiesDao.findByName(nameCity);
        sight.setCity(city);
        if (city!=null){
            sightsDao.save(sight);
            System.out.println("Збережено: " + sight);
        } else {
            System.out.println("Cheater detected");
        }

    }

    @PostMapping("/updateSightAJAX{nameCity}")
    public void updateSightAJAX(@RequestBody Sight sight,
                                @PathVariable String nameCity) {
        City city = citiesDao.findByName(nameCity);
        sight.setCity(city);
        if (city!=null){
            sightsDao.save(sight);
            System.out.println("Оновлено: " + sight);
        } else {
            System.out.println("Cheater detected");
        }
    }








    @PostMapping("/saveUniversityAJAX")
    public void saveCountyAJAX(@RequestParam String nameUniversity,
                               @RequestParam String direction,
                               @RequestParam String ownership,
                               @RequestParam String formOfTraining,
                               @RequestParam String dateOfCreation,
                               @RequestParam String street,
                               @RequestParam String nameCity) {
        LocalDate date = LocalDate.parse(dateOfCreation, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(date);
        University university = new University(nameUniversity,direction,ownership,formOfTraining,date,street);
        City city = citiesDao.findByName(nameCity);
        university.setCity(city);
        if (city!=null){
            universitiesDao.save(university);
            System.out.println("Збережено: " + university);
        } else {
            System.out.println("Cheater Detected!");
        }

    }

    @PostMapping("/updateUniversityAJAX{nameCity}")
    public void updateButtonUniversity(@RequestBody University university,
                                       @PathVariable String nameCity) {
        City city = citiesDao.findByName(nameCity);
        university.setCity(city);
        if (city!=null){
            universitiesDao.save(university);
            System.out.println("Оновлено: " + university);
        } else {
            System.out.println("Cheater Detected!");
        }
    }


}
