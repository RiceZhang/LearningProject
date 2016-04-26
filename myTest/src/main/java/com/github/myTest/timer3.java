package com.github.myTest;

/**
 * Created by R on 2016/4/15.
 */
public class timer3 {
    public static void main(String[] args) {
        // run in a second
        final long timeInterval = 1000;// 1000 ms eques 1s
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    // ------- code for task to run
                    System.out.println("Hello !!");
                    // ------- ends here
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
