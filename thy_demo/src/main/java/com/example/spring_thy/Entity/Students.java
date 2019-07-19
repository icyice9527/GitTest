package com.example.spring_thy.Entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Students {

//    @Min(201200)
    private int id;

//    @NotNull
//    @Size(min=2,max=10)
    private String name;

    private String school;

    private int score;

//    public Students(){}
//
//    public Students(Students student){
//        this.id=student.id;
//        this.name=student.name;
//        this.school=student.school;
//        this.score=student.score;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }


}
