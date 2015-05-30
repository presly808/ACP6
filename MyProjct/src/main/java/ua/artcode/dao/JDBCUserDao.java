package ua.artcode.dao;

import ua.artcode.model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by serhii on 30.05.15.
 */
public class JDBCUserDao implements UserDao {


    public User create(User user) {





        return null;
    }

    public User findByEmail(String email) {
        return null;
    }

    public User findById(long id) {
        return null;
    }

    public void delete(long id) {

    }

    public void update(User user) {

    }

    public List<User> findAll() {
        List<User> users = new LinkedList<User>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MyProject");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, fullname, email FROM users;");

            while (resultSet.next()){ // row - object => relation -> oop model
                long id = resultSet.getLong("id");
                String fullname = resultSet.getString("fullname");
                String email = resultSet.getString("email");
                users.add(new User(id,fullname,email, null));
            }

            connection.close();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
