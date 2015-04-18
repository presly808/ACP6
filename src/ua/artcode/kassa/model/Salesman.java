package ua.artcode.kassa.model;

/**
 * Created by serhii on 18.04.15.
 */
public class Salesman {

    private String id;
    private String name;

    public Salesman(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
