package com.welcomeToTheInternet.utilties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties properties;

    public ReadConfig() {
        File src = new File("./Configuration/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getURL() {
        return properties.getProperty("baseURL");
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getInvalidUsername() {
        return properties.getProperty("invalidUsername");
    }

    public String getUserPassword() {
        return properties.getProperty("password");
    }

    public String getInvalidUserPassword() {
        return properties.getProperty("invalidPassword");
    }

    public String getChromePath() {
        return properties.getProperty("chromepath");
    }

    public String getFirefoxPath() {
        return properties.getProperty("firefoxpath");
    }

}

