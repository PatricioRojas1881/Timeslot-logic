package com.patricio.timeslot;

import com.patricio.timeslot.domain.DataPersistanceType;
import com.patricio.timeslot.presentation.ScheduleController;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("hello world!");

        DataPersistanceType dpt = DataPersistanceType.FILESYSTEM;
        ScheduleController sc = new ScheduleController(dpt);
        System.out.println(sc.createScheduleRequest());

        System.out.println("bye world!");
    }
}