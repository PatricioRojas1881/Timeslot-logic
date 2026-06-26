package com.patricio.timeslot.application;

import com.patricio.timeslot.domain.DataPersistanceType;
import com.patricio.timeslot.persistence.local.filesystem.FileScheduleDataRepository;
import com.patricio.timeslot.persistence.template.ScheduleDataRepository;

import java.io.IOException;

public class ScheduleService {
    private ScheduleDataRepository dataRepository;
    public ScheduleService(DataPersistanceType dpt) throws Exception {
        switch (dpt) {
            case FILESYSTEM:
                dataRepository = new FileScheduleDataRepository();
                break;
            case NONE:
                throw new RuntimeException("Data persistance set to NONE");
            default:
                throw new RuntimeException("Data persistance is unknown");
        }
    }

    public String createSchedule() {
        return dataRepository.createSchedule();
    }
}
