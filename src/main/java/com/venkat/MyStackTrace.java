package com.venkat;

import java.util.Scanner;

public class MyStackTrace {

    public String getStackTrace(Exception ex){
        StackTraceElement[] elements = ex.getStackTrace();
        StringBuffer stringBuffer = new StringBuffer(500);
        //stringBuffer.append(ex.toString());
        for(StackTraceElement ste: elements){
            stringBuffer.append(ste);
        }
        return stringBuffer.toString();
    }

    public static String getRelevantExceptionMessage(){
        String line = "ExceptionString:Object having label 1234-ABC-XYZ does not exist in table TRN_XHZ: LM20";
        Scanner sc = new Scanner(line);

        while(sc.hasNextLine()){
            line = sc.nextLine();
            if(line.contains("LM20") && line.contains(":Object")){
                int start = line.indexOf("having label");
                if(line.contains("having label")) {
                    start += "having label".length();
                }
                int end = line.indexOf("in table");
                line = line.substring(start, end);
                break;
            }
        }
        return line;
    }

    public static void main(String[] args) {
        System.out.println(getRelevantExceptionMessage());
    }
}
