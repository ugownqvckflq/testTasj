package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name ="username")
    String name;
    @Column(name ="email")
    String email;

    public User(String name, String email, String registrationDate) {
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public User() {

    }

    @Column(name ="registration_date")
    String registrationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }


}
