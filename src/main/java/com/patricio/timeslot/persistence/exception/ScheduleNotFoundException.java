package com.patricio.timeslot.persistence.exception;

public class ScheduleNotFoundException extends RuntimeException {
    public ScheduleNotFoundException(String message) {
        super(message);
    }
    public ScheduleNotFoundException(String message, Exception cause) {
        super(message, cause);
    }
}
