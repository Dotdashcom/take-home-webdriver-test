package com.ddm.utilties;

import java.util.HashMap;


public class RunOptionsUtility {

    // Read mvn command options and store them
    protected static HashMap<String, String> runOptionsProperties;

    private RunOptionsUtility() {}

    public static void initRunOpitons() {
        runOptionsProperties = new HashMap<>();

        if(System.getProperty("targetPlatform") != null) {
            runOptionsProperties.put("targetPlatform", System.getProperty("targetPlatform"));
        }
        if(System.getProperty("targetOS") != null) {
            runOptionsProperties.put("targetOS", System.getProperty("targetOS"));
        }
        if(System.getProperty("targetBrowser") != null) {
            runOptionsProperties.put("targetBrowser", System.getProperty("targetBrowser"));
        } else {
            //Default target browser is chrome
            runOptionsProperties.put("targetBrowser", "chrome");
        }
        if(System.getProperty("quitBrowser") != null) {
            runOptionsProperties.put("quitBrowser", System.getProperty("quitBrowser"));
        } else {
            runOptionsProperties.put("quitBrowser", "true");
        }
    }

    public static String getRunOption(String key) {
        return runOptionsProperties.get(key);
    }
}
