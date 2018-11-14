package epam.springbootmainproject.services.impl;

import epam.springbootmainproject.dao.UserDao;
import epam.springbootmainproject.models.User;
import epam.springbootmainproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public void save(User user) {
        if (user != null) {
            userDao.save(user);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> userList = userDao.findAll();
        if (userList == null){
            return new ArrayList<>(); /*для того щоб не отримати помилки*/
        }
        return userList;
    }

    @Override
    public User findOneDyId(int id) {
        return null;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findByUsername(username);
    }
}
