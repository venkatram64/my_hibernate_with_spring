package com.venkat;

import java.util.Calendar;

public class Hello  {

    private String name;

    public static int count = 1;

    public static void main(String[] args){

        Calendar cal = Calendar.getInstance();
        //cal.getWeekYear();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(month);
        System.out.println(year);
        System.out.println(day);
        System.out.println("*****************");

 /*       MyEg eg = new MyEg();

        String msg = eg.sayHello("Venkatram");
        System.out.println(msg);*/
        (new MyEg("Venkatram")).sayHello();

        System.out.println((new MyEg("Venkatram")).sayHello());

        String sourceTables = "table1";

        String[] st = sourceTables.split("\\|");

        String ft = st[0];



        if(sourceTables.split("\\|").length > 1){
            String sta = st[1];
        }

        String[] eg = {"Venkat", "Ram"};

        //new String[]{"", ""};

        String[] an = {new String("Venkatram"), new String("Ram")};



    }

    public void myHello(){
        this.equals("venkat");

    }
}
