package epam.springbootmainproject.controllers;

import epam.springbootmainproject.dao.CitiesDao;
import epam.springbootmainproject.dao.CountriesDao;
import epam.springbootmainproject.models.City;
import epam.springbootmainproject.models.Country;
import epam.springbootmainproject.models.enums.CountryContinentEnum;
import epam.springbootmainproject.models.enums.CountryPoliticalSystemEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class CustomRestController {

    @Autowired
    private CountriesDao countriesDao;

    @Autowired
    private CitiesDao citiesDao;

    @PostMapping("/saveCityAJAX")
    public /*@ResponseBody*/ List<City> saveCityAJAX(@RequestBody City city) {
        citiesDao.save(city);
        System.out.println("Збережено: " + city);
        return citiesDao.findAll();
    }

    @PostMapping("/saveCountyAJAXform")
    public void saveCountyAJAXform(@RequestParam String nameCountry,
                                   @RequestParam LocalDate dateOfCreation,
                                   @RequestParam String politicalSystem,
                                   @RequestParam String continent,
                                   @RequestParam String capital,
                                   @RequestParam int square,
                                   @RequestParam int population) {
        Country country = new Country(nameCountry, dateOfCreation, politicalSystem, continent, capital, square, population);
        countriesDao.save(country);
        System.out.println("Збережено: " + country);
    }


}
