package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void create(User user);
    List<User> getAllUsers();
    User getUser(Long id);
    void update(User user);
    void remove(Long id);
}
