package com.ddm.utilties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility {
    //To read and load test url and credentials from config file
    protected static Properties cfgProperties;

    public static void initConfigUtility(String configFilePathRelative) {
        File cfgFile = new File(configFilePathRelative);
        try {
            FileInputStream fis = new FileInputStream(cfgFile);
            cfgProperties = new Properties();
            cfgProperties.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println("Config file can't be located. " + e.getMessage());
        } catch(IOException e) {
            System.out.println("IO Exception while loading the config file. " + e.getMessage());
        }
    }

    private ConfigUtility() {}

    public static String getBaseURL() {
        return cfgProperties.getProperty("baseURL");
    }

    public static String getUsername() {
        return cfgProperties.getProperty("username");
    }

    public static String getPassword() {
        return cfgProperties.getProperty("password");
    }

    public static String getInvalidUsername() {
        return cfgProperties.getProperty("invalidUsername");
    }

    public static String getInvalidPassword() {
        return cfgProperties.getProperty("invalidPassword");
    }
}

