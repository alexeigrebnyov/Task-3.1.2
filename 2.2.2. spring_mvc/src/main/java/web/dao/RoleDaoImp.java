package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void newRole(Set<Role> roles) {
        roles.forEach(role -> entityManager.persist(role));
    }

    @Transactional
    @Override
    public Set<Role> getRole() {
        Set<Role> setrole = new HashSet<>();
        List<Role> listrole = entityManager.createQuery("select role from Role role").getResultList();
        setrole.addAll(listrole);
        return setrole;
    }
}