package com.alp.utilities;

public class BrowserUtils {

    public static void wait(int seconds) {
        try {
            Thread.sleep((long)(1000 * seconds));
            }
        catch (InterruptedException var2) {
            var2.printStackTrace();
        }
    }
}