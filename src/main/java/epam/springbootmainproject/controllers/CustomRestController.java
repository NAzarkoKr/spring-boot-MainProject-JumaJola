package epam.springbootmainproject.controllers;

import epam.springbootmainproject.dao.CountriesDao;
import epam.springbootmainproject.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CustomRestController {

    @Autowired
    private CountriesDao countriesDao;

    @PostMapping("/saveCountyAJAX")
    public /*@ResponseBody*/ List<Country> saveAJAX(@RequestBody Country country) {
        countriesDao.save(country);
        System.out.println("Збережено: " + country);
        return countriesDao.findAll();
    }


}
