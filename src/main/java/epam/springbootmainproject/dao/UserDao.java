package epam.springbootmainproject.dao;

import epam.springbootmainproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDao extends JpaRepository<User,Integer> {
    UserDetails findByUsername(String username);
}
