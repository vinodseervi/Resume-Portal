package com.java.resumeportal.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "userProfile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "theme")
    private int theme;
    @Column(name = "summary")
    private String summary;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public int getTheme() {
        return theme;
    }


    public void setTheme(int theme) {
        this.theme = theme;
    }


    public String getSummary() {
        return summary;
    }


    public void setSummary(String summary) {
        this.summary = summary;
    }
}
