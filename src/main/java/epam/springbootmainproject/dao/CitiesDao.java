package epam.springbootmainproject.dao;

import epam.springbootmainproject.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CitiesDao extends JpaRepository<City,Integer> {
    @Query("select c from City c where c.nameCity=:nameCity")
    City findByName(@Param("nameCity") String nameCity);
}
