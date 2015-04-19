package ua.artcode.ds;

import java.util.Date;

public class User {


    private int id; // must be unique
    private int age;
    private String number;
    private Date birthday;
    private double salary;
    private long distance;

    public User() {
    }

    public User(int age, String number,
                Date birthday, double salary,
                long distance) {
        this.age = age;
        this.number = number;
        this.birthday = birthday;
        this.salary = salary;
        this.distance = distance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (distance != user.distance) return false;
        if (Double.compare(user.salary, salary) != 0) return false;
        if (birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) return false;
        if (number != null ? !number.equals(user.number) : user.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + age;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        long temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (distance ^ (distance >>> 32));
        return result;
    }
}
