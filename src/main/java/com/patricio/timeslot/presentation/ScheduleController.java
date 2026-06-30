package com.patricio.timeslot.presentation;

import com.patricio.timeslot.application.ScheduleService;
import com.patricio.timeslot.domain.DataPersistanceType;
import com.patricio.timeslot.domain.Schedule;

public class ScheduleController {
    private ScheduleService scheduleService;

    public ScheduleController(DataPersistanceType dpt) throws Exception {
        this.scheduleService = new ScheduleService(dpt);
    }

    public String createScheduleRequest() {
        return scheduleService.createSchedule();
    }

    public Schedule getScheduleByIDRequest(String id) {
        return scheduleService.getScheduleByID(id);
    }
}
