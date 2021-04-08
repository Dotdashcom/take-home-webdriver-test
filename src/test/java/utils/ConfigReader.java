package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /**
     * This method is used to read property values from properties file
     * @param property is key name of the property
     * @param filePath is location of our config file
     * @return method will return a String value of the property
     */
    public static String readProperty(String property, String filePath){
        Properties prop = null;
        try (FileInputStream fileInput = new FileInputStream(filePath)) {
            prop = new Properties();
            prop.load(fileInput);
        } catch (IOException e1){
            e1.printStackTrace();
        }

        return prop.getProperty(property);
    }

    /**
     * This method is used to read property values from default property file
     * @param property
     * @return
     */
    public static String readProperty(String property){
        Properties prop = null;
        try (FileInputStream fileInput = new FileInputStream("src/test/resources/config/configuration.properties")){
            prop = new Properties();
            prop.load(fileInput);
        }catch (IOException e){
            e.printStackTrace();
        }
        return prop.getProperty(property);
    }
}
