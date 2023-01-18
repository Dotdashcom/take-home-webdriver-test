package com.qa.take_home_webdriver_test.utils;

import com.qa.take_home_webdriver_test.constants.Paths;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    /**
     * This method is used to load properties from config.properties file
     *
     * @return Properties prop object
     */

    public static Properties initiateProperties() {
        Properties properties = null;
        try {
            properties = new Properties();
            FileInputStream ip = new FileInputStream(Paths.CONFIG);
            try {
                properties.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
