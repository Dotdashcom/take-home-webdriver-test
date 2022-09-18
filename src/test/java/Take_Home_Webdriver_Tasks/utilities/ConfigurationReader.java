package Take_Home_Webdriver_Tasks.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();

    static {

        try {

            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);

        } catch (IOException e) {
            System.out.println("File not found in ConfigurationReader class");
            e.printStackTrace();
        }
    }
    public static String getProperty(String keyword) {

        return properties.getProperty(keyword);
    }


}
