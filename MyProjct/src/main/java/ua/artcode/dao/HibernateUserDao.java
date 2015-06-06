package ua.artcode.dao;

import org.apache.log4j.Logger;
import ua.artcode.exception.NoUserFoundException;
import ua.artcode.model.User;

import javax.persistence.*;
import java.util.List;

/**
 * Created by serhii on 06.06.15.
 */
public class HibernateUserDao implements UserDao {

    private static final Logger LOG = Logger.getLogger(HibernateUserDao.class);
    private EntityManagerFactory factory;

    public HibernateUserDao(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public User create(User user) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin(); //
            entityManager.persist(user);
            transaction.commit();//
            return user;
        }catch (Exception e){
            LOG.error(e);
            transaction.rollback();
        }
        entityManager.close();
        return null;

    }

    public User findByEmail(String email) {
        EntityManager entityManager = factory.createEntityManager();
        // Builder
        TypedQuery<User> query = entityManager
                .createQuery("FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .setMaxResults(1);

        List<User> users = query.getResultList();


        return users.get(0);
    }

    public User findById(long id) {
        EntityManager entityManager = factory.createEntityManager();
        //EntityTransaction transaction = entityManager.getTransaction();
        return entityManager.find(User.class,id);
    }

    public void delete(long id) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        User found = entityManager.find(User.class,id);
        try{
            transaction.begin();
            entityManager.remove(found);
            transaction.commit();
        }catch (Exception e){
            LOG.error(e);
            transaction.rollback();
        }
    }

    public void update(User user) {

    }

    public List<User> findAll() {
        EntityManager entityManager = factory.createEntityManager();
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        List<User> all = query.getResultList();
        return all;
    }
}
