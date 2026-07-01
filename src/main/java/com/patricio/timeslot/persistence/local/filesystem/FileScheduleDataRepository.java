package com.patricio.timeslot.persistence.local.filesystem;

import com.patricio.timeslot.domain.Schedule;
import com.patricio.timeslot.persistence.exception.ScheduleDataException;
import com.patricio.timeslot.persistence.exception.ScheduleNotFoundException;
import com.patricio.timeslot.persistence.template.ScheduleDataRepository;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class FileScheduleDataRepository implements ScheduleDataRepository {
    private final File scheduleFile;
    private final ObjectMapper mapper;

    public FileScheduleDataRepository() throws IOException {
        Path scheduleFilePath = Paths.get("data", "file-repository", "schedules.json");
        Files.createDirectories(scheduleFilePath.getParent());
        scheduleFile = scheduleFilePath.toFile();
        mapper = new ObjectMapper();

        // create schedules.json if necessary and check for permissions
        if (scheduleFile.createNewFile()) initializeScheduleJSON();
        if (!scheduleFile.canRead()) throw new IOException("Read permission for schedules.json is required");
        if (!scheduleFile.canWrite()) throw new IOException("Write permission for schedules.json is required");
    }

    private void initializeScheduleJSON() {
        ObjectNode node = mapper.createObjectNode();
        node.putArray("schedules");
        mapper.writeValue(scheduleFile, node);
    }

    @Override
    public Schedule getScheduleByID(String id) throws ScheduleNotFoundException {
        JsonNode jsonNode = mapper.readTree(scheduleFile);

        for (JsonNode node : jsonNode.get("schedules").asArray()) {
            Schedule schedule = mapper.treeToValue(node, Schedule.class);
            if (id.equals(schedule.getUuid())) return schedule;
        }

        throw new ScheduleNotFoundException(
                String.format("Could not find a Schedule with UUID [%s]", id)
        );
    }

    @Override
    public String createSchedule() throws ScheduleDataException {
        Schedule schedule = new Schedule("Empty Schedule", UUID.randomUUID().toString());

        JsonNode jsonNode = mapper.readTree(scheduleFile);
        jsonNode.get("schedules")
                .asArray()
                .add(mapper.convertValue(schedule, JsonNode.class));

        mapper.writeValue(scheduleFile, jsonNode);

        return schedule.getUuid();
    }
}
