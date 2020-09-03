package com.alp.utilities;

public class StringUtility {
    public static boolean verifyEquals(String expected,String actual) {
        System.out.println(expected.equals(actual)?"PASS":"FAIL");
        return expected.equals(actual);

    }
    public static void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}




