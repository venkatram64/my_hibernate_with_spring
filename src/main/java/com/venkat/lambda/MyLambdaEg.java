package com.venkat.lambda;

interface StringLength{
    int getLength(String s);
}

public class MyLambdaEg {

    private static void printStrLength(StringLength sl){
        System.out.println(sl.getLength("Hello, Venkatram"));
    }

    public static void main(String[] args) {
        printStrLength(s -> s.length());
    }

}
