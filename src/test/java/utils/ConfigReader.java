package utils;

import java.io.*;
import java.util.Properties;

public class ConfigReader {
    private static final String CONFIG_FILE = "properties/configuration.properties";

    private static Properties properties;
    private static InputStreamReader inputStream;

    static {
        initInputStream();
        loadProperties();
    }

    public static boolean getPropertyAsBoolean(String key) {
        return Boolean.parseBoolean(getProperty(key));
    }

    public static int getPropertyAsInt(String key) {
        return Integer.parseInt(getProperty(key));
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    private static void loadProperties() {
        properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Couldn't load properties: " + e.getMessage());
        }
    }

    private static void initInputStream() {
        inputStream = new InputStreamReader(getFromResources(CONFIG_FILE));
    }

    private static InputStream getFromResources(String resource) {
        return ConfigReader.class.getClassLoader().getResourceAsStream(resource);
    }

}
