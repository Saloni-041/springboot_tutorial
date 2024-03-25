package com.project.SpringBootApp.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FixedDelay {
    // To trigger the scheduler every 3 seconds with
    // an initial delay of 5 seconds.
    @Scheduled(fixedDelay = 3000,initialDelay = 5000)
    public void scheduleTask()
    {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        String date=simpleDateFormat.format(new Date());
        System.out.println("Fixed Delay Scheduler: Task running at "+date);
    }
}
//The fixedDelay element specified in the @Scheduled annotation executes the annotated method at a fixed time period
// between the end of the previous invocation and the start of the next invocation.
// It basically waits for the previous task to be complete. The time value specified for this element
// is in milliseconds.
//The initialDelay element specified here allows mentioning the amount of time it waits
// before the invocation of the first task. The time value specified for this element is in milliseconds.
//Here the scheduler defined starts with an initial delay of 5 seconds and
// goes on to execute the task at a fixed delay of 3 seconds