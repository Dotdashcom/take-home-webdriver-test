package com.mitt.core;

import org.testng.log4testng.Logger;

public class Log {

    private static Logger Log = Logger.getLogger(Log.class);

    public static void startTestCase(String sTestCaseName){
        Log.info("*******************************************************");
        Log.info("##  "+sTestCaseName+ "  ##");
        Log.info("*******************************************************");
    }

    public static void endTestCase(String sTestCaseName){
        Log.info("XXXXXXX"+"-END OF TEST-"+"  XXXXXX");
        Log.info("X");
    }

    public static void info(String message) { Log.info(message); }

    public static void warn(String message) { Log.warn(message); }

    public static void error(String message) { Log.error(message); }

    public static void fatal(String message) { Log.fatal(message); }

    public static void debug(String message) { Log.debug(message); }
}
