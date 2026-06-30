package com.patricio.timeslot;

import com.patricio.timeslot.domain.DataPersistanceType;
import com.patricio.timeslot.presentation.ScheduleController;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("hello world!");

        DataPersistanceType dpt = DataPersistanceType.FILESYSTEM;
        ScheduleController sc = new ScheduleController(dpt);
        String uuid = sc.createScheduleRequest();

        System.out.println(sc.getScheduleByIDRequest(uuid).getName());
        sc.getScheduleByIDRequest(uuid + "123");

        System.out.println("bye world!");
    }
}