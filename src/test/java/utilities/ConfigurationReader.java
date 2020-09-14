package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    public ConfigurationReader() {
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }

    static {
        try {
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}
