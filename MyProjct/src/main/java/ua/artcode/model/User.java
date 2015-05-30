package ua.artcode.model;

/**
 * Created by serhii on 30.05.15.
 */
public class User {

    private long id;
    private String fullName;
    private String email;
    private String pass;



    public User() {
    }

    public User(long id, String fullName,
                String email, String pass) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.pass = pass;
    }

    public User(String fullName, String email,
                String pass) {
        this.fullName = fullName;
        this.email = email;
        this.pass = pass;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
