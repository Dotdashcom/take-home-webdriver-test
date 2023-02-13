package com.dotdash.webtest.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    protected static Properties properties;

    public static void initializeProperties() {

        File file = new File("src\\main\\configuration.properties");
        properties = new Properties();

        try {
            properties.load(new FileInputStream(file));

        } catch (FileNotFoundException e) {
            System.out.println("Configuration property file doesn't exist.");
        } catch (IOException e) {
            System.out.println("Unknown Input Output exception occured while opening Configuration file.");
        }
    }

    public static String readProperty(String key) {
        return properties.getProperty(key);
    }
}
