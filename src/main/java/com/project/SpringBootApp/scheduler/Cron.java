package com.project.SpringBootApp.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Cron {
    //The cron element specified in the @Scheduled annotation allows defining cron-like expressions
    // to include triggers on the second, minute, hour, day of the month, month, and day of the week.
    // The expression specified here in the cron element directs spring boot to trigger the scheduler
    // every one minute between 17:00.00 to 17:59.00 on 27 feb
    @Scheduled(cron = "0 * 17 27 2 ?")
    public void scheduleTask()
    {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");   //SSS: Represents the milliseconds.
        String date=simpleDateFormat.format(new Date());
        System.out.println("Cron job Scheduler: Job running at "+date);
    }
}
