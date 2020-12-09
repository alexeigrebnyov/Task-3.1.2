package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);
    void create(User user);
    List<User> getAllUsers();
    User getUser(Long id);
    void update(User user);
    void remove(Long id);

}
