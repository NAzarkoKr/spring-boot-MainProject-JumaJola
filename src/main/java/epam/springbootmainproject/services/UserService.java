package epam.springbootmainproject.services;

import epam.springbootmainproject.models.User;

import java.util.List;

public interface UserService {

    /*в інтерфейсі повинно бути методи:
    Приймати юзера і сейвити його;
    Список всіх юзерів ......*/

    void save(User user);

    List<User> findAll();

    User findOneDyId(int id);


}
