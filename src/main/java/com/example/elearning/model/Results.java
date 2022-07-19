package com.example.elearning.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Results {

    @Id
    @GeneratedValue
    private Long id;

    private String Name;

    private String points;

    private String courseName;

    public Results(String name,String points, String courseName) {
        this.Name = name;
        this.points = points;
        this.courseName = courseName;
    }

    public Results() {

    }
}
