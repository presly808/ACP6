package ua.artcode.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class UserPost extends GeneratedIdentifierEntity {

    @Column
    private String title;
    @Column(nullable = false)
    private String body;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;

    public UserPost() {
    }

    public UserPost(long id, String title,
                    String body, User owner) {
        setId(id);
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

    public UserPost(String title, String body, User owner) {
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserPost{");
        sb.append("creationDate=").append(creationDate);
        sb.append(", body='").append(body).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
