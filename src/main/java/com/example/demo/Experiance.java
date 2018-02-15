package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Experiance {
@Autowired
    @Id
    private int id;
@NotNull
    private String jobExperiance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobExperiance() {
        return jobExperiance;
    }

    public void setJobExperiance(String jobExperiance) {
        this.jobExperiance = jobExperiance;
    }
}
