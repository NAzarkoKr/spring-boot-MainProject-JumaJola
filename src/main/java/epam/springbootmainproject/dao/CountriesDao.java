package epam.springbootmainproject.dao;

import epam.springbootmainproject.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountriesDao extends JpaRepository<Country,Integer> {
    @Query("select c from Country c where c.nameCountry=:nameCountry")
    Country findByName(@Param("nameCountry") String name);
}
