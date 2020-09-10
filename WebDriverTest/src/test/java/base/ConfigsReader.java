package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {

    public static FileInputStream fis;
    public static Properties prop;

    /**
     * Method read *.properties files
     * @param filePath path to *.properties file
     */
    public static void read(String filePath) {

        try {
            fis = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fis);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method gets value of corresponding key(property)
     * @param key from *.properties file
     * @return property String value
     */
    public static String getProperty(String key) {
        return prop.getProperty(key);

    }
}
