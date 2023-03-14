package environment;

import io.github.ensyb.properties.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentManager {

    public static void initWebDriver() {
        Properties conf = null;
        try {
            conf = loadProperties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.setProperty("webdriver.chrome.driver", conf.getProperty("PATH_CHROMEDRIVER"));
        WebDriver driver = new ChromeDriver();
        RunEnvironment.setWebDriver(driver);
        RunEnvironment.setUrlBase(conf.getProperty("URL_BASE"));
    }

    public static void initWebDriverWithOptions(ChromeOptions options) {
        Properties conf = null;
        try {
            conf = loadProperties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.setProperty("webdriver.chrome.driver",conf.getProperty("PATH_CHROMEDRIVER") );
        WebDriver driver = new ChromeDriver(options);
        RunEnvironment.setWebDriver(driver);
        RunEnvironment.setUrlBase(conf.getProperty("URL_BASE"));

    }

    public static void shutDownDriver() {
        RunEnvironment.getWebDriver().quit();
    }

    public static Properties loadProperties() throws IOException {
        Properties configuration = new Properties();
        InputStream inputStream = PropertiesLoader.class
                .getClassLoader()
                .getResourceAsStream("application.properties");
        configuration.load(inputStream);
        inputStream.close();
        return configuration;
    }
}
