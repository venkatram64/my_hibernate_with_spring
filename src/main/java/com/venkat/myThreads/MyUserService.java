package com.venkat.myThreads;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyUserService {
    private static Logger logger = Logger.getLogger(MyUserService.class.getName());
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args){
        for(int i = 0; i < 100; i++){
            int id = i;
            threadPool.submit(() ->{
                String birthDate = birthDate(id);
                logger.info("i= " + id  + ": "+ birthDate);
            });
        }
        threadPool.shutdown();
    }

    public static String birthDate(int userId){
        Date birthDate = new Date();
        SimpleDateFormat sd = ThreadSafeDateFormatter.sdf.get();
        return sd.format(birthDate);
    }
}
