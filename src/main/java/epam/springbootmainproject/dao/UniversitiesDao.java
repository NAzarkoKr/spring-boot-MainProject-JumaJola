package epam.springbootmainproject.dao;

import epam.springbootmainproject.models.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversitiesDao extends JpaRepository<University,Integer> {
}
