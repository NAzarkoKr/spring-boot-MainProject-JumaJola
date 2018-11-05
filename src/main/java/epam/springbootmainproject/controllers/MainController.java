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
        model.addAttribute("countryList", countryList);
        return "countries/search";
    }

    @GetMapping("/createNewCountryButton")
    public String createNewCountryButton() {
        return "countries/create";
    }

    @GetMapping("/createNewCountryButtonView")
    public String createNewCountry() {
        return "countries/create";
    }

    @GetMapping("/viewAllCountries")
    public String cancelCreate(){
        return "redirect:/country";
    }

    @GetMapping("/viewCountry/{id}")
    public String resolveSingleContact(@PathVariable int id,
                                       Model model) {
        Country country = countriesDao.findById(id).get();
        model.addAttribute("country", country);
        return "countries/view";
    }

    @GetMapping("/editCountry/{id}")
    public String editCountry(@PathVariable int id,
                              Model model) {
        Country country = countriesDao.findById(id).get();
        model.addAttribute("country", country);
        return "countries/edit";
    }

    @GetMapping("/cancelEdit/{id}")
    public String cancelEdit(@PathVariable int id, Model model) {
        Country country = countriesDao.findById(id).get();
        model.addAttribute("country", country);
        return "countries/view";
    }

    @GetMapping("/updateCountyEdit/{id}")
    public String updateCountyAJAXform(@PathVariable int id,
                                       @RequestParam String nameCountry,
                                       @RequestParam String dateOfCreation, /*витаягуємо стрінгу*/
                                       @RequestParam String politicalSystem,
                                       @RequestParam String continent,
                                       @RequestParam String capital,
                                       @RequestParam int square,
                                       @RequestParam int population) {
        Country country = countriesDao.findById(id).get();
        LocalDate date = LocalDate.parse(dateOfCreation, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        country.setNameCountry(nameCountry);
        country.setDateOfCreation(date);
        country.setPoliticalSystem(politicalSystem);
        country.setContinent(continent);
        country.setCapital(capital);
        country.setSquare(square);
        country.setPopulation(population);
        countriesDao.save(country);
        System.out.println("Збережено: " + country);
        return "countries/view";
    }


    @GetMapping("/cities")
    public String cities(Model model) {
        List<City> cityList = citiesDao.findAll();
        model.addAttribute("cityList", cityList);
        return "cities/search";
    }

    @GetMapping("/createNewCityButton")
    public String createNewCityButton() {
        return "cities/create";
    }

    @GetMapping("/viewAllCities")
    public String viewAllCities(){
        return "redirect:/cities";
    }

    @GetMapping("/editCity/{id}")
    public String editCity(@PathVariable int id,
                              Model model) {
        City city = citiesDao.findById(id).get();
        model.addAttribute("city", city);
        return "cities/edit";
    }
}
