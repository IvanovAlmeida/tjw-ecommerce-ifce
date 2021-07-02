package br.edu.ifce.dao;

import br.edu.ifce.model.User;
import br.edu.ifce.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO {
    public void Insert(User user) {
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
        manager.close();
    }

    public boolean VerifyIfUsedEmail(String email) {
        EntityManager manager = JPAUtil.getEntityManager();
        TypedQuery<User> query = manager.createQuery("SELECT u FROM User u WHERE u.email = ?1", User.class);
        query.setParameter(1, email);
        List<User> users = query.getResultList();
        manager.close();

        return users.size() > 0;
    }

    public User FindByEmailAndPassword(String email, String password) {
        EntityManager manager = JPAUtil.getEntityManager();
        TypedQuery<User> query = manager.createQuery("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2", User.class);
        query.setParameter(1, email);
        query.setParameter(2, password);

        List<User> users = query.getResultList();
        manager.close();

        if(users.size() == 0)
            return null;
        return users.get(0);
    }
}
