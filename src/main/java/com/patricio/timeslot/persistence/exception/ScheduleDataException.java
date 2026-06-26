package com.patricio.timeslot.persistence.exception;

public class ScheduleDataException extends RuntimeException {
    public ScheduleDataException(String message) {
        super(message);
    }
    public ScheduleDataException(String message, Exception cause) {
        super(message, cause);
    }
}
