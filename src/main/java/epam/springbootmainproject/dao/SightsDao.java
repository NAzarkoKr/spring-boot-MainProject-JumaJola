package epam.springbootmainproject.dao;

import epam.springbootmainproject.models.Sight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SightsDao extends JpaRepository<Sight,Integer> {
}
