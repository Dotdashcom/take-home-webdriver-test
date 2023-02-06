package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader  {
    protected static Properties applicationProperties;

    public static void loadProperties()  {
        applicationProperties = new Properties();

        try {
            FileInputStream propFileIS = new FileInputStream("src/configs/app.properties");
            applicationProperties.load(propFileIS);

        } catch (FileNotFoundException e)  {
            System.out.println("File not Found.");
        } catch (IOException e)  {
            System.out.println("Input/Output Exception.");
        }
    }
    public static String getProperty(String key)  {
        return applicationProperties.get(key).toString();
    }
}