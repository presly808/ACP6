package ua.artcode.model;

public class UserPost {

    private long id;
    private String title;
    private String body;
    private User owner;

    public UserPost() {
    }

    public UserPost(long id, String title,
                    String body, User owner) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

    public UserPost(String title, String body, User owner) {
        this.title = title;
        this.body = body;
        this.owner = owner;
    }
}
