package com.venkat.myThreads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MySchedular {

    private static ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

    public static void runOneTask(){
        service.schedule( () -> System.out.println("Running once only"), 10, TimeUnit.SECONDS);
    }

    public static void runningRepeatedly(){
        service.scheduleAtFixedRate(() -> System.out.println("Runs repeatedly for every 10 seconds"), 15, 10, TimeUnit.SECONDS);
    }

    public static void runRepeatedlyAfterCompletingPreviousTask(){
        service.scheduleWithFixedDelay(()-> System.out.println("Runs repeatedly 10 seconds after previous task completes"), 15, 10, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        runOneTask();
        runningRepeatedly();
        runRepeatedlyAfterCompletingPreviousTask();
        //service.shutdown();
    }
}


