package ua.artcode.db;

import ua.artcode.model.User;

import java.util.*;

/**
 * Created by serhii on 20.06.15.
 */
public class UserContainer {

    private Map<String, User> keys = new HashMap<>();
    private Map<Long,User> map = new TreeMap<>();
    private long count;

    public UserContainer() {
        init();
    }

    public boolean isLogged(String key){
        return keys.containsKey(key);
    }

    public User getUserByKey(String key){
        return keys.get(key);
    }

    public void addKeys(String key, User user){
        keys.put(key,user);
    }

    private void init() {
        map.put(1L,new User(1,"Kolia",23));
        map.put(2L,new User(2,"Vasia",30));
        map.put(3L,new User(3,"Bogdan",40));
        map.put(4L, new User(4, "Serhii", 23));

        count = 5;
    }

    public void addUser(User user){
        user.setId(count);
        map.put(count, user);
        count++;
    }

    public User getUser(long id){
        return map.get(id);
    }

    public Collection<User> userList(){
        return map.values();
    }
}
