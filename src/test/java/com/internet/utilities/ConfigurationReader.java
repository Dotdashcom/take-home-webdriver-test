package com.internet.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static final Properties configFile;
    static {
        try {
            String path = System.getProperty("user.dir")+"/configuration.properties";
            FileInputStream input = new FileInputStream(path);
            configFile = new Properties();
            configFile.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }
    public static String getProperty(String keyName) {
        String property = System.getProperty(keyName);
        if (property == null){
            property = configFile.getProperty(keyName);
        }
        return property;
    }

}


