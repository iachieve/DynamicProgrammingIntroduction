package com.company.RecursionIntroduction;

public class Timer {
    public static void countDown(int seconds) throws InterruptedException {
        if(seconds < 0) return;
        System.out.println(seconds);
        Thread.sleep(1000);
        countDown(seconds - 1);
    }

    public static void main(String[] args) throws InterruptedException {
        countDown(5);
    }
}
