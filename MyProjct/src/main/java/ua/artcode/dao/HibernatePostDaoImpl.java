package ua.artcode.dao;

import ua.artcode.model.UserPost;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by serhii on 07.06.15.
 */
public class HibernatePostDaoImpl implements PostDao {

    private EntityManagerFactory factory;

    public HibernatePostDaoImpl() {
    }

    public HibernatePostDaoImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public UserPost create(UserPost user) {
        return null;
    }

    @Override
    public UserPost findById(long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void update(UserPost user) {

    }

    @Override
    public List<UserPost> findAll() {
        return null;
    }

    @Override
    public List<UserPost> userPosts(long id) {
        return null;
    }

    @Override
    public List<UserPost> findByKey(String keyWord) {
        EntityManager manager = factory.createEntityManager();
        return manager
                .createQuery("SELECT p From UserPost p WHERE p.title like :keyWord", UserPost.class)
                .setParameter("keyWord", keyWord)
                .setFirstResult(0)
                .setMaxResults(10)
                .getResultList();
    }

    public void setFactory(EntityManagerFactory factory) {
        this.factory = factory;
    }
}
