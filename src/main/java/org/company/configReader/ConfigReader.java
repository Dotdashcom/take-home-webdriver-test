package org.company.configReader;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    private ConfigReader(){}
    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";


    static {
        try {
            FileInputStream inputStream = new FileInputStream(CONFIG_FILE_PATH);
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String getProperty(String keyName){
        return properties.getProperty(keyName);

    }

    public static void setProperty(String keyName, String value){
        properties.setProperty(keyName, value);
    }

}
