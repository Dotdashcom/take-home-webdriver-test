package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static {
        try {
            String path="configuration.properties";
            FileInputStream fileInputStream=new FileInputStream(path);
            properties=new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
