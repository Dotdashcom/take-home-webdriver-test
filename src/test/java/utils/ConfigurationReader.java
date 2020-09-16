package utils;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {
    private final static Logger logger = Logger.getLogger(ConfigurationReader.class);
    private static Properties properties;

    static {
        try (InputStream inputStream = new FileInputStream("src/test/resources/configuration.properties")) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("Failed to load properties file!");
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }

    public static String getProperty(String property) {
        return properties.getProperty(property);
    }
}
