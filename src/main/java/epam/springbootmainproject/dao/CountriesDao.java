package epam.springbootmainproject.dao;

import epam.springbootmainproject.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesDao extends JpaRepository<Country,Integer> {
}
