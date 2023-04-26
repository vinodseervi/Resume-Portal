package com.java.resume.portal.entity.resumeData;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "skill_1")
    private String skill;

    @Override
    public String toString() {
        return "Skills{" +
                "id=" + id +
                ", skill='" + skill + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
