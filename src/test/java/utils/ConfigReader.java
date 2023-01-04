package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = null;

    private ConfigReader() throws Exception {
        throw new Exception();
    }

    public static void readProperties(String filename) {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(filename);
            properties.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static String getValue(String key) {
        return properties.getProperty(key);
    }

    public static boolean getMode() {
        return Boolean.parseBoolean(getValue("HEADLESS"));
    }

    public static String getBaseUrl() {
        return getValue("BASE_URL");
    }

    public static String getUsername() {
        return getValue("USERNAME");
    }

    public static String getPassword() {
        return getValue("PASSWORD");
    }
}
