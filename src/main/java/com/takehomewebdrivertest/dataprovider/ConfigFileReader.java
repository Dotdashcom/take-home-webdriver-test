package com.takehomewebdrivertest.dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private final Properties properties;


    public ConfigFileReader() {
        BufferedReader reader;
        String propertyFilePath = "src/main/java/com/takehomewebdrivertest//dataprovider/config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public String getBaseUrl() {
        String url = properties.getProperty("baseUrl");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getDownloadPath() {
        String downPath = properties.getProperty("downloadPath");
        if (downPath != null) return downPath;
        else throw new RuntimeException("Download Path not specified in the Configuration.properties file.");
    }

}