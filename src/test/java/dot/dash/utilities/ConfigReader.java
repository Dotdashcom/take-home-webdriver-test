package dot.dash.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop = new Properties();

    static {

        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            prop.load(file);
            file.close();

        } catch (IOException e) {
            System.out.println("Reader: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
