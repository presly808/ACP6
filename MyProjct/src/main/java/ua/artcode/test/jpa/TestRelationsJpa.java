package ua.artcode.test.jpa;

import ua.artcode.model.User;
import ua.artcode.model.UserPost;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by serhii on 07.06.15.
 */
public class TestRelationsJpa {


    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_unit");

        User user = new User("Lev","cascade","1234");
        UserPost post1 = new UserPost("title1", "sdfsd", user);
        UserPost post2 = new UserPost("title2", "some post", user);
        UserPost post3 = new UserPost("title3", "text test", user);

        user.getPostList().add(post1);
        user.getPostList().add(post2);
        user.getPostList().add(post3);



        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(post1);
        manager.persist(post2);
        manager.persist(post3);
        manager.persist(user);
        manager.getTransaction().commit();


    }
}
