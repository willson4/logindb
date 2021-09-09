package com.seek;

public class User {


    private String firstname;
    private String lastname;
    private String email;
    private int age;
    private String state;
    private String course;



    public User(int id, String firstname, String lastname, String email, int age, String state, String course) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email =email;
        this.age =age;
        this.state =state;
        this.course =course;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
