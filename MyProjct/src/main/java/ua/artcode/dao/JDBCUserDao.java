package ua.artcode.dao;

import org.apache.log4j.Logger;
import ua.artcode.converter.ORConverter;
import ua.artcode.converter.UserORConverter;
import ua.artcode.model.User;
import ua.artcode.utils.ConnectionFactory;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class JDBCUserDao implements UserDao {

    private static final Logger LOG = Logger.getLogger(JDBCUserDao.class);
    private ORConverter<User> userConverter = new UserORConverter();

    public User create(User user) {

        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement ps = connection.
                    prepareStatement("INSERT INTO users (fullname,email,pass) VALUES (?,?,?)");

            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPass());

            ps.execute();

            return findByEmail(user.getEmail());


        } catch (SQLException e) {
            LOG.error(e);
        }

        return null;
    }

    public User findByEmail(String email) {
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement ps = connection.
                    prepareStatement("SELECT id,fullname,email FROM users WHERE email=?");

            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();

            return userConverter.convert(resultSet);
        } catch (SQLException e) {
            LOG.error(e);
        }


        return null;
    }

    public User findById(long id) {
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement ps = connection.
                    prepareStatement("SELECT id,fullname,email FROM users WHERE id=?");

            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();

            return userConverter.convert(resultSet);
        } catch (SQLException e) {
            LOG.error(e);
        }
        return null;
    }

    public void delete(long id) {
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement ps = connection.
                    prepareStatement("DELETE FROM users WHERE id=?");

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            LOG.error(e);
        }
    }

    public void update(User user) {

    }

    public List<User> findAll() {
        List<User> users = null;

        try (Connection connection = ConnectionFactory.getConnection()){

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, fullname, email FROM users;");
            return userConverter.convertAll(resultSet);
        }  catch (SQLException e) {
            LOG.error(e);
        }

        return users;
    }
}
