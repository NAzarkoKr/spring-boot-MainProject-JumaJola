package epam.springbootmainproject.controllers;

import epam.springbootmainproject.dao.CountriesDao;
import epam.springbootmainproject.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private CountriesDao countriesDao;

    @GetMapping("/")
    public String home() {
        System.out.println("home");
        return "index";
    }

    @GetMapping("/country")
    public String country(){
        return "countries/search";
    }

    @GetMapping("/createNewCountryButton")
    public String createNewCountryButton(){
        return "countries/create";
    }

}
