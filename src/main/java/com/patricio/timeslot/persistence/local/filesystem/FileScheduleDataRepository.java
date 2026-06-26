package com.patricio.timeslot.persistence.local.filesystem;

import com.patricio.timeslot.persistence.exception.ScheduleDataException;
import com.patricio.timeslot.persistence.template.ScheduleDataRepository;
import com.patricio.timeslot.domain.Schedule;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;

public class FileScheduleDataRepository implements ScheduleDataRepository {
    private final File scheduleFile;

    public FileScheduleDataRepository() throws IOException {
        Path scheduleFilePath = Paths.get("data", "file-repository", "schedules.xml");
        scheduleFile = scheduleFilePath.toFile();

        // create schedule.xml is necessary and check for permissions
        scheduleFile.createNewFile();
        if (!scheduleFile.canRead()) throw new IOException("Read permission for schedules.xml is required");
        if (!scheduleFile.canWrite()) throw new IOException("Write permission for schedules.xml is required");
    }

    @Override
    public Schedule getScheduleByID(String id) throws ScheduleDataException {
        return null;
    }

    @Override
    public String createSchedule() throws ScheduleDataException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(scheduleFile);
            writer.write("proof of concept\n");
            writer.close();
        } catch (IOException e) {
            throw new ScheduleDataException("Could not create a new Schedule", e);
        }

        return "Done";
    }
}
