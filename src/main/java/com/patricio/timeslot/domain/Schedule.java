package com.patricio.timeslot.domain;

import java.util.LinkedList;

public class Schedule {
    private String uuid;
    private String name;
    private LinkedList<Course> courses = new LinkedList<>();

    public Schedule() {
    }

    public Schedule(String name, String uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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
