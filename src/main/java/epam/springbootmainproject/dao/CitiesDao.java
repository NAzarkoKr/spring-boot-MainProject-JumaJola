package epam.springbootmainproject.dao;

import epam.springbootmainproject.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesDao extends JpaRepository<City,Integer> {
}
