package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private  UserDao userDao;
    private RoleDao roleDao;
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);

    }

    @Override
    public void remove(Long id) {
        userDao.remove(id);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public void newRole(Set<Role> roles) {
        roleDao.newRole(roles);
    }

    @Override
    public Set<Role> getRole() {
        return roleDao.getRole();
    }
}
