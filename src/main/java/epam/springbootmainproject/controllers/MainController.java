package epam.springbootmainproject.controllers;

import epam.springbootmainproject.dao.CitiesDao;
import epam.springbootmainproject.dao.CountriesDao;
import epam.springbootmainproject.dao.UniversitiesDao;
import epam.springbootmainproject.models.City;
import epam.springbootmainproject.models.Country;
import epam.springbootmainproject.models.University;
import epam.springbootmainproject.models.enums.UniversiryOwnershipEnum;
import epam.springbootmainproject.models.enums.UniversityFormOfTrainingEnum;
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
    @Autowired
    private UniversitiesDao universitiesDao;

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
    @GetMapping("/universities")
    public String universities(Model model) {
        List<University> universitiesList = universitiesDao.findAll();
        model.addAttribute("universitiesList", universitiesList);
        return "universities/search";
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

    @GetMapping("/createNewUniversitiesButton")
    public String createNewUniversityButton() {
        return "universities/create";
    }

    @GetMapping("/createNewUniversitiesButtonView")
    public String createNewUniversity() {
        return "universities/create";
    }

    @GetMapping("/viewAllUniversities")
    public String cancelCreateUniersity(){
        return "redirect:/universities";
    }

    @GetMapping("/viewCountry/{id}")
    public String resolveSingleContact(@PathVariable int id,
                                       Model model) {
        Country country = countriesDao.findById(id).get();
        model.addAttribute("country", country);
        return "countries/view";
    }
    @GetMapping("/viewUniversities/{id}")
    public String resolveSingleContactUniversity(@PathVariable int id,
                                       Model model) {
        University universities = universitiesDao.findById(id).get();
        model.addAttribute("universities", universities);
        return "universities/view";
    }

    @GetMapping("/editCountry/{id}")
    public String editCountry(@PathVariable int id,
                              Model model) {
        Country country = countriesDao.findById(id).get();
        model.addAttribute("country", country);
        return "countries/edit";
    }
    @GetMapping("/editUniversity/{id}")
    public String editUniversity(@PathVariable int id,
                              Model model) {
        University universities = universitiesDao.findById(id).get();
        model.addAttribute("universities", universities);
        return "universities/edit";
    }

    @GetMapping("/cancelEdit/{id}")
    public String cancelEdit(@PathVariable int id, Model model) {
        Country country = countriesDao.findById(id).get();
        model.addAttribute("country", country);
        return "countries/view";
    }
    @GetMapping("/cancelEditUniversity/{id}")
    public String cancelEditUniversity(@PathVariable int id, Model model) {
        University universities = universitiesDao.findById(id).get();
        model.addAttribute("universities", universities);
        return "universities/view";
    }

    @PostMapping("/updateCountyEdit/{id}")
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
        return "redirect:/viewCountry/{id}";
    }
    @PostMapping("/updateUniversitiesEdit/{id}")
    public String updateUniversitiesAJAXform(@PathVariable int id,
                                       @RequestParam String nameUniversity,
                                       @RequestParam  int direction,
                                       @RequestParam String country,
                                       @RequestParam String city,
                                       @RequestParam String street,
                                       @RequestParam String dateOfCreation, /*витаягуємо стрінгу*/
                                       @RequestParam  UniversiryOwnershipEnum ownership,
                                       @RequestParam UniversityFormOfTrainingEnum formOfTraining


    ){


        University universities = universitiesDao.findById(id).get();
        LocalDate date = LocalDate.parse(dateOfCreation, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        universities.setNameUniversity(nameUniversity);
        universities.setDirection(direction);
        universities.setCountry(country);
        universities.setCity(city);
        universities.setStreet(street);
        universities.setDateOfCreation(date);
        universities.setOwnership(ownership);
        universities.setFormOfTraining(formOfTraining);





        universitiesDao.save(universities);
        System.out.println("Збережено: " + universities);
        return "redirect:/viewUniversities/{id}";
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
