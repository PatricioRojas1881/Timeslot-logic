package com.patricio.timeslot.domain;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Class {
    private DayOfWeek weekday;
    private LocalTime startTime;
    private LocalTime endTime;

    public Class(DayOfWeek weekday, LocalTime startTime, LocalTime endTime) {
        if (weekday == null) throw new NullPointerException("weekday cannot be null");
        if (startTime == null) throw new NullPointerException("startTime cannot be null");
        if (endTime == null) throw new NullPointerException("endTime cannot be null");

        if (startTime.isAfter(endTime)) throw new IllegalArgumentException("startTime has to be before endTime");

        this.weekday = weekday;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        if (startTime == null)  throw new NullPointerException("startTime cannot be null");
        if (endTime.isBefore(startTime)) throw new IllegalArgumentException("startTime has to be before endTime");

        this.startTime = startTime;
    }

    public DayOfWeek getWeekday() {
        return weekday;
    }

    public void setWeekday(DayOfWeek weekday) {
        this.weekday = weekday;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        if (endTime == null)  throw new NullPointerException("endTime cannot be null");
        if (startTime.isAfter(endTime)) throw new IllegalArgumentException("endTime has to be after startTime");

        this.endTime = endTime;

    }
}
