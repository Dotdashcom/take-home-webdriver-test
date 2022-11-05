package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    static {

        String path = "configuration.properties";
        try {

            FileInputStream file = new FileInputStream(path);

            properties= new Properties();
            properties.load(file);

            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    This method accepts the key and returns the value
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}