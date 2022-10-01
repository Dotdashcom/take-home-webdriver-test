package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
        } catch (IOException e) {
            System.out.println("file not found in ConfigurationReader class");
            e.printStackTrace();
        }
    }
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}


