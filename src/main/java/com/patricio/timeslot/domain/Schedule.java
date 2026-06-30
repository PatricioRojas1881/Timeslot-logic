package com.patricio.timeslot.domain;

import java.util.LinkedList;

public class Schedule {
    private String name;
    private LinkedList<Course> courses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Course> getCourses() {
        return courses;
    }

    public void setCourses(LinkedList<Course> courses) {
        this.courses = courses;
    }
}
