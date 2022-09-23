package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    protected static Properties autProperties;

    public static void initializeProperties(){
        File autConfigFile = new File("src/main/resources/applicationUnderTestConfig.properties");

        autProperties = new Properties();
        try {
            autProperties.load(new FileInputStream(autConfigFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getAutProperty(String key){
        return autProperties.getProperty(key);
    }
}
