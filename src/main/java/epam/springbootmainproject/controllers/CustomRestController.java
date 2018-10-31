package epam.springbootmainproject.controllers;

import epam.springbootmainproject.dao.CitiesDao;
import epam.springbootmainproject.dao.CountriesDao;
import epam.springbootmainproject.models.City;
import epam.springbootmainproject.models.Country;
import epam.springbootmainproject.models.enums.CountryContinentEnum;
import epam.springbootmainproject.models.enums.CountryPoliticalSystemEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/saveCityAJAX")
    public /*@ResponseBody*/ List<City> saveCityAJAX(@RequestBody City city) {
        citiesDao.save(city);
        System.out.println("Збережено: " + city);
        return citiesDao.findAll();
    }

//    @PostMapping("/saveCountyAJAXform")
//    public /*@ResponseBody*/ List<Country> saveCountyAJAXform(@RequestBody Country country) {
//        countriesDao.save(country);
//        System.out.println("Збережено: " + country);
//        return countriesDao.findAll();
//    }

    @PostMapping("/saveCountyAJAXform")
    public void saveCountyAJAXform(@RequestParam String nameCountry,
                                   @RequestParam String dateOfCreation, /*витаягуємо стрінгу*/
                                   @RequestParam String politicalSystem,
                                   @RequestParam String continent,
                                   @RequestParam String capital,
                                   @RequestParam int square,
                                   @RequestParam int population) {

        /*перетворюємо стрінгу знову в локал дату, щоб зберегти обєкт в БД(трабли зі збереженням)*/
        LocalDate date = LocalDate.parse(dateOfCreation, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(date);

        Country country = new Country(nameCountry, date, politicalSystem, continent, capital, square, population);
        countriesDao.save(country);
        System.out.println("Збережено: " + country);
    }


}
