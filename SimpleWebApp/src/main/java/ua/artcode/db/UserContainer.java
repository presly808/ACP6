package ua.artcode.db;

import ua.artcode.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by serhii on 20.06.15.
 */
public class UserContainer {

    private Map<Long,User> map = new TreeMap<>();
    private long count;

    public UserContainer() {
        init();
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

    public Collection<User> userList(){
        return map.values();
    }
}
