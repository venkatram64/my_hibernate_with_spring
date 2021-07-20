package com.venkat.sim;

public class Airtel implements SIM{
    @Override
    public void call() {
        System.out.println("Calling...");
    }

    @Override
    public void sms() {
        System.out.println("Sending...");
    }
}
