package utils;

import java.io.*;
import java.util.Properties;

public abstract class PropertyKeys {

    public static Properties property;

    public static String getProperty(String key) {
        try (InputStream input = new FileInputStream(System.getProperty("user.dir") + "/config.properties")) {
            property = new Properties();
            property.load(input);
            return property.getProperty(key);
        } catch (IOException exception) {
            return exception.toString();
        }
    }

    public static void setProperty(String key, String value) {
        try (OutputStream output = new FileOutputStream(System.getProperty("user.dir") + "/config.properties")) {
            property = new Properties();
            property.setProperty(key, value);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
