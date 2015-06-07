package ua.artcode.test.jpa;

import ua.artcode.model.User;
import ua.artcode.model.UserPost;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by serhii on 07.06.15.
 */
public class TestGettingUserWithPosts {


    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_unit");

        EntityManager manager = factory.createEntityManager();

        User user = manager.find(User.class, 6L);

        List<UserPost> postList = user.getPostList();

        for (UserPost post : postList) {
            System.out.println(post);
        }

    }
}
