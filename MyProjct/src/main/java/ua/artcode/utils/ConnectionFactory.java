package ua.artcode.utils;


import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static final Logger LOG = Logger.getLogger(ConnectionFactory.class);

    private static String url;
    private static String user;
    private static String pass;

    static {

        try {

            Properties properties = new Properties();
            properties.load(new FileInputStream("app.properties"));
            url = properties.getProperty("db.url");
            user = properties.getProperty("db.user");
            pass = properties.getProperty("db.pass");

            Class.forName("com.mysql.jdbc.Driver");
        } catch (IOException e) {
            LOG.error(e);
        } catch (ClassNotFoundException e) {
            LOG.error(e);
        }


    }

    public static Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(url,user,pass);
            return connection;
        } catch (SQLException e) {
            LOG.error(e);
        }
        return null;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
