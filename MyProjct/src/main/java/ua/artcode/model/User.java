package ua.artcode.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name", length = 30)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
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
