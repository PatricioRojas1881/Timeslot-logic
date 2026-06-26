package com.patricio.timeslot.domain;

import java.util.LinkedList;

public class Course {
    private String name;
    private LinkedList<Group> groups;
    private Group selectedGroup;

    public Course(String name) {
        this.name = name;
        groups = new LinkedList<Group>();
    }

    public LinkedList<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group g) {
        groups.add(g);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getSelectedGroup() {
        return selectedGroup;
    }

    public void setSelectedGroup(Group selectedGroup) {
        if (!groups.contains(selectedGroup)) throw new IllegalArgumentException("selectedGroup is not an available group of this course");
        this.selectedGroup = selectedGroup;
    }
}
