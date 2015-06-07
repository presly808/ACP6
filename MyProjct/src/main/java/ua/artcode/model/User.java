package ua.artcode.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends GeneratedIdentifierEntity {


    @Column(name = "full_name", length = 30)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String pass;

    @OneToMany(mappedBy = "owner",
            cascade = {CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    private List<UserPost> postList = new LinkedList<>();

    @Enumerated(EnumType.ORDINAL)
    private PostType postType;

    public User() {
    }

    public User(long id, String fullName,
                String email, String pass) {
        setId(id);
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

    public List<UserPost> getPostList() {
        return postList;
    }

    public void setPostList(List<UserPost> postList) {
        this.postList = postList;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
