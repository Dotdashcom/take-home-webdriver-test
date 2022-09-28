package com.dotdash.mkb.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileUtils {

    private static Properties properties;
    private static String propertyFilePath= "src\\main\\resources\\general.config";

    public static void readProperties(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch ( FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("general.config not found at " + propertyFilePath);
        }
    }

    public static String getProperty(String property){
        return properties.getProperty(property);
    }

}