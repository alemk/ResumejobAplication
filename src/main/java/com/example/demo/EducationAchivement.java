package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class EducationAchivement {
@Autowired
    @Id
    private int id;
@NotNull
    private String Achivement;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAchivement() {
        return Achivement;
    }

    public void setAchivement(String achivement) {
        Achivement = achivement;
    }
}
