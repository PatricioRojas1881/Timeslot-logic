package com.patricio.timeslot.presentation;

import com.patricio.timeslot.application.ScheduleService;
import com.patricio.timeslot.domain.DataPersistanceType;

import java.io.IOException;

public class ScheduleController {
    private ScheduleService scheduleService;

    public ScheduleController(DataPersistanceType dpt) throws Exception {
        this.scheduleService = new ScheduleService(dpt);
    }

    public String createScheduleRequest() {
        return scheduleService.createSchedule();
    }
}
