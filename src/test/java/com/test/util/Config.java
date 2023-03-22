package com.test.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream inputStream = new FileInputStream("./src/test/java/com/test/config/config.properties");
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl(String key) {
        return properties.getProperty(key + ".url");
    }
}
