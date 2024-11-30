package com.example.crowdfunding.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Creator {

    private Integer Id;

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private String password;

    private boolean accountStatus;
    //the account must be accepted by the admin. When created is false, which means that the account is yet be to accepted
    //only when the account id accepted (true) he/she can publish projects

//    @OneToMany( mappedBy = "creator", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
//    private List<Project> projects;


    public Creator() {
        this.accountStatus = false;
    }

    public Creator(String password, String username, String lastName, String firstName, String email) {
        this.password = password;
        this.accountStatus = false;
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public Creator(Integer id, String firstName, String lastName, String email, String username, String password) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.accountStatus = false;
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }
//
//    public List<Project> getProjects() {
//        return projects;
//    }
//
//    public void setProjects(List<Project> projects) {
//        this.projects = projects;
//    }
}
