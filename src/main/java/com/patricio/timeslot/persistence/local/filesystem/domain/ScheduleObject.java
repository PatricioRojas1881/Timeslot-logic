package com.patricio.timeslot.persistence.local.filesystem.domain;

public class ScheduleObject {
    private String uuid;
    private String name;

    public ScheduleObject() {
    }

    public ScheduleObject(String name, String uuid) {
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
}
