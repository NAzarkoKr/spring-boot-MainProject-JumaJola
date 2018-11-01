package epam.springbootmainproject.controllers;

import epam.springbootmainproject.dao.CitiesDao;
import epam.springbootmainproject.dao.CountriesDao;
import epam.springbootmainproject.models.City;
import epam.springbootmainproject.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private CountriesDao countriesDao;

    @Autowired
    private CitiesDao citiesDao;

    @GetMapping("/")
    public String home() {
        System.out.println("home");
        return "index";
    }



    @GetMapping("/country")
    public String country(Model model) {
        List<Country> countryList = countriesDao.findAll();
        model.addAttribute("countryList",countryList);
        return "countries/search";
    }
    @GetMapping("/createNewCountryButton")
    public String createNewCountryButton() {
        return "countries/create";
    }
    @GetMapping("/newCountry")
    public String createNewCountry() {
        return "cities/create";
    }
    @GetMapping("/viewCountry/{id}")
    public String resolveSingleContact(@PathVariable int id,
                                       Model model){
        Country country = countriesDao.findById(id).get();
        model.addAttribute("country", country);
        return "countries/view";
    }
    @GetMapping("/editCountry/{id}")
    public String editCountry(@PathVariable int id,
                              Model model){
        Country country = countriesDao.findById(id).get();
        model.addAttribute("country", country);
        return "countries/edit";
    }
    @PostMapping("/updateCountry")
    public String updateContact(@RequestParam String nameCountry,
                                @RequestParam String dateOfCreation, /*витаягуємо стрінгу*/
                                @RequestParam String politicalSystem,
                                @RequestParam String continent,
                                @RequestParam String capital,
                                @RequestParam int square,
                                @RequestParam int population){
        LocalDate date = LocalDate.parse(dateOfCreation, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(date);

        Country country = new Country(nameCountry, date, politicalSystem, continent, capital, square, population);
        countriesDao.save(country);
        System.out.println("Збережено: " + country);
        return "countries/edit";
    }



    @GetMapping("/cities")
    public String cities(Model model) {
        List<City> cityList = citiesDao.findAll();
        model.addAttribute("cityList",cityList);
        return "cities/search";
    }
    @GetMapping("/createNewCityButton")
    public String createNewCityButton() {
        return "cities/create";
    }

}
