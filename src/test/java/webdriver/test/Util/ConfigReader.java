package webdriver.test.Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static String getConfigProperties(String property) throws IOException {
        InputStream inputFile = null;
        Properties properties = null;

        try {
            inputFile = new FileInputStream("src/test/configuration/config.properties");
            properties = new Properties();
            properties.load(inputFile);
        } catch (Exception e){
            System.out.println("Exception Error - " + e.getMessage());
        } finally {
            if (inputFile != null) {
                inputFile.close();
            }
        }

        if (properties != null) {
            return properties.getProperty(property);
        }

        return null;
    }
}
