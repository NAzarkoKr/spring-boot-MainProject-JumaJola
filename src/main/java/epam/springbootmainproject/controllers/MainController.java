package epam.springbootmainproject.controllers;

import epam.springbootmainproject.dao.CitiesDao;
import epam.springbootmainproject.dao.CountriesDao;
import epam.springbootmainproject.dao.SightsDao;
import epam.springbootmainproject.dao.UniversitiesDao;
import epam.springbootmainproject.models.*;
import epam.springbootmainproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @Autowired
    private CountriesDao countriesDao;

    @Autowired
    private CitiesDao citiesDao;

    @Autowired
    private UniversitiesDao universitiesDao;

    @Autowired
    private SightsDao sightsDao;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home() {
        System.out.println("home");
        return "index";
    }


    @GetMapping("/CountrySearch")
    public String CountrySearch(Model model) {
        List<Country> countryList = countriesDao.findAll();
        model.addAttribute("countryList", countryList);
        return "countries/search";
    }

    @GetMapping("/country")
    public String country(Model model) {
        List<Country> countryList = countriesDao.findAll();
        model.addAttribute("countryList", countryList);
        return "redirect:/CountrySearch";
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
    public String cancelCreate() {
        return "redirect:/country";
    }

    @GetMapping("/viewCountry/{id}")
    public String resolveSingleContact(@PathVariable int id,
                                       Model model) {
        Country country = countriesDao.findById(id).get();
        model.addAttribute("country", country);
        List<City> cityList = citiesDao.findAll();
        model.addAttribute("cityList", cityList);
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
        return "redirect:/viewCountry/{id}";
    }

    @GetMapping("/deleteCountry/{id}")
    public String delete(@PathVariable int id) {
        Country country = countriesDao.findById(id).get();
        System.out.println("Видалено: " + country);
        countriesDao.delete(country);
        return "redirect:/viewAllCountries";
    }

    @GetMapping("/searchButtonCountry/{nameCountry}")
    public @ResponseBody Country searchButtonCountry(
            @PathVariable String nameCountry,
            Model model){
        Country country = countriesDao.findByName(nameCountry);
        model.addAttribute("cityList", country);
        System.out.println(country);
        System.out.println(nameCountry);
        return country;
    }








    @GetMapping("/cities")
    public String cities(Model model) {
        List<City> cityList = citiesDao.findAll();
        model.addAttribute("cityList", cityList);
        return "redirect:/CitiesSearch";
    }

    @GetMapping("/CitiesSearch")
    public String CitiesSearch(Model model) {
        List<City> cityList = citiesDao.findAll();
        model.addAttribute("cityList", cityList);
        return "cities/search";
    }

    @GetMapping("/viewAllCities")
    public String viewAllCities() {
        return "redirect:/cities";
    }

    @GetMapping("/viewCity/{id}")
    public String CityById(@PathVariable int id,
                           Model model) {
        City city = citiesDao.findById(id).get();
        model.addAttribute("city", city);
        List<Sight> sightList = sightsDao.findAll();
        model.addAttribute("sightList",sightList);
        List<University> universityList = universitiesDao.findAll();
        model.addAttribute("universityList",universityList);
        return "cities/view";
    }

    @GetMapping("/createNewCityButton")
    public String createNewCityButton(Model model) {
        List<Country> countryList = countriesDao.findAll();
        model.addAttribute("countryList",countryList);
        return "cities/create";
    }

    @GetMapping("/editCity/{id}")
    public String editCity(@PathVariable int id,
                           Model model) {
        City city = citiesDao.findById(id).get();
        model.addAttribute("city", city);
        List<Country> countryList = countriesDao.findAll();
        model.addAttribute("countryList", countryList);
        return "cities/edit";
    }

    @GetMapping("/createNewCityButtonView")
    public String createNewCityButtonView() {
        return "redirect:/createNewCityButton";
    }

    @GetMapping("/cancelCityEdit/{id}")
    public String cancelCityEdit(@PathVariable int id,
                                 Model model) {
        City city = citiesDao.findById(id).get();
        model.addAttribute("city", city);
        return "redirect:/viewCity/{id}";
    }

    @GetMapping("/deleteCity/{id}")
    public String deleteCity(@PathVariable int id) {
        City city = citiesDao.findById(id).get();
        System.out.println("Видалено: " + city);
        citiesDao.delete(city);
        return "redirect:/viewAllCities";
    }








    @GetMapping("/sights")
    public String sights(Model model) {
        List<Sight> sightList = sightsDao.findAll();
        model.addAttribute("sightList", sightList);
        return "redirect:/SightsSearch";
    }

    @GetMapping("/SightsSearch")
    public String SightsSearch(Model model) {
        List<Sight> sightList = sightsDao.findAll();
        model.addAttribute("sightList", sightList);
        return "sights/search";
    }

    @GetMapping("/createNewSightButton")
    public String createNewSightButton(Model model) {
        List<City> cityList = citiesDao.findAll();
        model.addAttribute("cityList",cityList);
        return "sights/create";
    }

    @GetMapping("/viewSight/{id}")
    public String viewSight(@PathVariable int id,
                            Model model) {
        Sight sight = sightsDao.findById(id).get();
        model.addAttribute("sight", sight);
        return "sights/view";
    }


    @GetMapping("/createNewSightButtonView")
    public String createNewSightButtonView() {
        return "redirect:/createNewSightButton";
    }

    @GetMapping("/editSight/{id}")
    public String editSight(@PathVariable int id,
                            Model model) {
        Sight sight = sightsDao.findById(id).get();
        model.addAttribute("sight", sight);
        List<City> cityList = citiesDao.findAll();
        model.addAttribute("cityList",cityList);
        return "sights/edit";
    }

    @GetMapping("/cancelSightEdit/{id}")
    public String cancelSightEdit(@PathVariable int id, Model model) {
        Sight sight = sightsDao.findById(id).get();
        model.addAttribute("sight", sight);
        return "redirect:/viewSight/{id}";
    }

    @GetMapping("/deleteSight/{id}")
    public String deleteSight(@PathVariable int id) {
        Sight sight = sightsDao.findById(id).get();
        System.out.println("Видалено: " + sight);
        sightsDao.delete(sight);
        return "redirect:/sights";
    }
    
    @GetMapping("/viewAllSight")    
    public String viewAllSight(){
        return "redirect:/SightsSearch";
    }








    @GetMapping("/createNewUniversityButton")
    public String createNewUniversityButton(Model model) {
        List<City> cityList = citiesDao.findAll();
        model.addAttribute("cityList",cityList);
        return "universities/create";
    }

    @GetMapping("/viewUniversity/{id}")
    public String resolveSingleContactUniversity(@PathVariable int id,
                                                 Model model) {
        University university = universitiesDao.findById(id).get();
        model.addAttribute("university", university);
        return "universities/view";
    }

    @GetMapping("/editUniversity/{id}")
    public String editUniversity(@PathVariable int id,
                                 Model model) {
        University university = universitiesDao.findById(id).get();
        model.addAttribute("university", university);
        List<City> cityList = citiesDao.findAll();
        model.addAttribute("cityList",cityList);
        return "universities/edit";
    }

    @GetMapping("/cancelUniversityEdit/{id}")
    public String cancelEditUniversity(@PathVariable int id, Model model) {
        University university = universitiesDao.findById(id).get();
        model.addAttribute("university", university);

        return "redirect:/viewUniversity/{id}";
    }

    @GetMapping("/universities")
    public String universities() {
        return "redirect:/UniversitiesSearch";
    }

    @GetMapping("/UniversitiesSearch")
    public String UniversitiesSearch(Model model) {
        List<University> universityList = universitiesDao.findAll();
        model.addAttribute("universityList", universityList);
        return "universities/search";
    }

    @GetMapping("/createNewUniversityButtonView")
    public String createNewUniversity() {
        return "universities/create";
    }

    @GetMapping("/deleteUniversity/{id}")
    public String deleteUniversity(@PathVariable int id) {
        University university = universitiesDao.findById(id).get();
        System.out.println("Видалено: " + university);
        universitiesDao.delete(university);
        return "redirect:/universities";
    }

    @GetMapping("/viewAllUniversities")
    public String viewAllUniversities(){
        return "redirect:/UniversitiesSearch";
    }

    
    
    
    
    
    
    
    @PostMapping("/successURL")    
    public String successURL(){
        return "index";
    }


    @PostMapping("/saveUser")    
    public String saveUser(User user){
        String encode = passwordEncoder.encode(user.getPassword()); /*закодовує пароль*/
        user.setPassword(encode);
        userService.save(user);
        return "login";
    }

}
