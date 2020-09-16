package com.automation.utilities;

public class BrowserUtils {

    public static void wait(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
