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
    
    @GetMapping("/view")
    public String resolveSingleContact(){

        return "countries/view";
    }


}
