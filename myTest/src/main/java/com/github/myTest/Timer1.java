package com.github.myTest;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by R on 2016/4/15.
 */
public class Timer1 {

    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // task to run goes here
                System.out.println("Hello !!!");
            }
        };
        Timer timer = new Timer();
        long delay = 0;
        long intevalPeriod = 1 * 1000;// 1秒执行一次
        // schedules the task to be run in an interval
        timer.scheduleAtFixedRate(task, delay, intevalPeriod);
    } // end of main



}
