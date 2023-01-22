package ui_automation.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReder {

    private static Properties properties;

    public static String getProperties(String fileName, String key) {
        try {

            String path = "src/test/resources/" + fileName;
            FileInputStream stream = new FileInputStream(path);
            properties = new Properties();
            properties.load(stream);
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);

    }

}
