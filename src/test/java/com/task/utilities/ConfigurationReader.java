package com.task.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    static Properties properties;

    static {
        String path = "configuration.properties";
        FileInputStream file = null;
        try {
            file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropery(String key){
        return properties.getProperty(key);
    }

}