package com.venkat.myThreads;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyUserService {

    private static Logger logger = Logger.getLogger(MyUserService.class.getName());

    private ExecutorService threadPool;

    public MyUserService(){
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of cores: " + coreCount);
        //thread pool size is 10, so 10 threads will be created
        threadPool = Executors.newFixedThreadPool(coreCount);//Executors.newFixedThreadPool(10);
    }

    public void process(){
        for(int i = 0; i < 100; i++){ //submitting 100 tasks for 10 threads
            int id = i;
            //internally executor service uses the blocking queue to add all the tasks
            //then each thread will take the task from blocking queue and performs the task
            threadPool.submit(() ->{ // this is the thread
                String birthDate = birthDate(id);
                logger.info("i= " + id  + ": "+ birthDate);
            });
        }
        threadPool.shutdown();
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }

    public static String birthDate(int userId){
        Date birthDate = new Date();
        //thread local means once instance for one thread
        SimpleDateFormat sd = ThreadSafeDateFormatter.sdf.get();
        return sd.format(birthDate);
    }

    public static void main(String[] args){
        MyUserService myUserService = new MyUserService();
       myUserService.process();
    }


}
