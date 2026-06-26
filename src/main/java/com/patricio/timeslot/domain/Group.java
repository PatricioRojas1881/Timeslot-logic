package com.patricio.timeslot.domain;

import java.util.LinkedList;

public class Group {
    private String name;
    private LinkedList<Class> classes;

    public Group(String name) {
        this.name = name;
        this.classes = new LinkedList<>();
    }

    public void setClasses(LinkedList<Class> classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Class> getClasses() {
        return classes;
    }

    public void addClass(Class c) {
        classes.add(c);
    }

}
