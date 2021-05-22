package utils;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class CommonUtils {
    private static Properties getProperties() {
        Properties prop = null;
        try (InputStream input = new FileInputStream("./src/test/resources/config.properties")) {
            prop = new Properties();
            // load a properties file
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public static String getBaseUrl() {
        return getProperties().getProperty("baseUrl");
    }

    public static String getDownloadDirectory() {
        return getProperties().getProperty("downloadPath");
    }

    public static String getUploadDirectory() {
        return getProperties().getProperty("uploadPath");
    }

    public static String getChromeDriverPath() {
        return getProperties().getProperty("driverPath");
    }

    public static void tearDownAfterTest(WebDriver driver) {
        driver.quit();
    }

    public static String[] getValidCreds() {
        String[] validCreds = new String[2];
        validCreds[0] = getProperties().getProperty("valid.username");
        validCreds[1] = getProperties().getProperty("valid.password");
        return validCreds;
    }

    public static String[] getInvalidCreds() {
        String[] invalidCreds = new String[2];
        invalidCreds[0] = getProperties().getProperty("invalid.username");
        invalidCreds[1] = getProperties().getProperty("invalid.password");
        return invalidCreds;
    }
}
