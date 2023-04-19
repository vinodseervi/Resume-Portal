package com.java.resumeportal.entity.resumeData;

import jakarta.persistence.*;

@Entity
@Table(name = "hobbies")
public class Hobbies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "hobbies_name")
    private String hobbiesName;

    @Override
    public String toString() {
        return "Hobbies{" +
                "id=" + id +
                ", hobbiesName='" + hobbiesName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHobbiesName() {
        return hobbiesName;
    }

    public void setHobbiesName(String hobbiesName) {
        this.hobbiesName = hobbiesName;
    }
}
