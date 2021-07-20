package com.venkat;

import java.util.Date;
import java.text.SimpleDateFormat;

public class MyEg {

    String msg = null;

    public MyEg(String msg){
        this.msg = msg;
    }

    private static void dateFormat(){
        try {
            String strD = "Nov 13 2023 12:00AM";
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy hh:mmaa");
            Date d = sdf.parse(strD);
            System.out.println(d);
            System.out.println(d.getTime());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        dateFormat();
        /*myExceptionTest();
        String str = "IR....";
        if(str.contains(".")) {
            String[] splitter = str.split("\\.");

            System.out.printf("Split: " + splitter[0]);

            System.out.println("Current directory: " + System.getProperty("user.dir"));
            System.out.println("USER: " + System.getProperty("user.name"));

            String issueType = "F";
            if(issueType == "F"){
                System.out.println("Issue Type...");
            }
        }*/
    }

    public static void myExceptionTest(){
        try{
            try{
                int sum = 1;
                sum = sum/0;
            }catch (Exception e){
                throw new ArithmeticException(e.getMessage());
            }
        }catch(ArithmeticException ae){
            System.out.println("exception is " + ae.getMessage());
        }
    }

    public String sayHello(){
        return msg;
    }
}
