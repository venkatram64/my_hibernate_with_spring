package com.venkat.fileLock;

import org.apache.log4j.Logger;

import java.io.File;

public class HowToStop {
    private static Logger logger = Logger.getLogger(HowToStop.class.getName());

    public static void main(String[] args) {
        while(true){
            try {
                Thread.sleep(5000);
                logger.info("Hi...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(exitCondition()){
                break;
            }
        }
    }

    static boolean exitCondition(){
        File f = new File("exit.cmd");
        if(f.exists() && !f.isDirectory()){
            f.delete();
            return true;
        }
        return false;
    }
}
