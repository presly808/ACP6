package ua.artcode.storage;

import ua.artcode.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by serhii on 30.05.15.
 */
public class AppDataContainer {

    private Map<Long,User> users;

    public AppDataContainer() {
        init();

    }

    private void init() {

        users = new TreeMap<Long, User>();
        users.put(1L, new User(1, "Pupkin Vasia", "vas@gmail.com", "1234"));
        users.put(2L, new User(2, "Ivanov Ivan", "ivan@gmail.com", "1234"));
        users.put(3L, new User(3, "Nickolas Duglas", "nick@gmail.com", "1234"));
        users.put(4L, new User(4, "Richardson Jack", "jack@gmail.com", "1234"));
        users.put(5L, new User(5, "Bogdan Ivanovich", "bogdan@gmail.com", "1234"));

    }

    public Map<Long, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Long, User> users) {
        this.users = users;
    }
}
