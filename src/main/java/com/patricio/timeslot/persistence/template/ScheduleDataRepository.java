package com.patricio.timeslot.persistence.template;

import com.patricio.timeslot.domain.Schedule;
import com.patricio.timeslot.persistence.exception.ScheduleDataException;

public interface ScheduleDataRepository {
    public Schedule getScheduleByID(String id) throws ScheduleDataException;
    public String createSchedule() throws ScheduleDataException;
}
