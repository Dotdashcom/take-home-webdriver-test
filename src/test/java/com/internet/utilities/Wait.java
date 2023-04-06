package com.internet.utilities;

public class Wait {
    public static void  wait (int second) {
        try {
            Thread.sleep(1000*second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
