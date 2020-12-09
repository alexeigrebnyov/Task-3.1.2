package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("userDao")
public class UserDaoImp implements UserDao{

    @PersistenceContext
    EntityManager entityManager;

   public EntityManager getEntityManager() {return  this.entityManager;}

    @Transactional
    @Override
    public User getUserByName(String name) {
        return (User) entityManager.createQuery("select user from User user where user.name=:name")
                .setParameter("name", name)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void create(User user) {
        getEntityManager().persist(user);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
         return getEntityManager()
                 .createQuery("select user From User user").getResultList();
    }

    @Transactional
    @Override
    public User getUser(Long id) {
        return getEntityManager().find(User.class, id);
    }

    @Transactional
    @Override
    public void update(User user) {

        getEntityManager().merge(user);

    }

    @Transactional
    @Override
    public void remove(Long id) {
        getEntityManager().createQuery("DELETE FROM User user WHERE user.id =:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
