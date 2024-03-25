package com.project.SpringBootApp.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FixedRate
{
    // To trigger the scheduler to run every two seconds
    @Scheduled(fixedRate = 2000)
    public void scheduleTask()
    {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        String date=simpleDateFormat.format(new Date());
        System.out.println("Fixed rate Scheduler: Task running at "+ date);
    }
}
//The fixedRate element specified in the @Scheduled annotation executes the annotated method at a fixed time period
// between invocations. It does not wait for the previous task to be complete.
// The time value specified for this element is in milliseconds.
//Here a fixed rate scheduler is defined which runs every 2 seconds.