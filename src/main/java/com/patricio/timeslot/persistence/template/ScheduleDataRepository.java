package com.patricio.timeslot.persistence.template;

import com.patricio.timeslot.domain.Schedule;
import com.patricio.timeslot.persistence.exception.ScheduleDataException;
import com.patricio.timeslot.persistence.exception.ScheduleNotFoundException;

public interface ScheduleDataRepository {
    Schedule getScheduleByID(String id) throws ScheduleNotFoundException;
    String createSchedule() throws ScheduleDataException;
}
