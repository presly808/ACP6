package ua.artcode.converter;

import ua.artcode.model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by serhii on 31.05.15.
 */
public class UserORConverter implements ORConverter<User> {


    @Override
    public User convert(ResultSet rs) {
        User user = new User();
        try {
            rs.next();  // row - object => relation -> oop model
            long id = rs.getLong("id");
            String fullname = rs.getString("fullname");
            String email = rs.getString("email");
            return new User(id,fullname,email,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> convertAll(ResultSet rs) {

        List<User> users = new LinkedList<User>();


        try {
            while (rs.next()) { // row - object => relation -> oop model
                long id = rs.getLong("id");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                users.add(new User(id, fullname, email, null));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return users;
    }
}
