package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverManager {
    public static WebDriver getWebDriver(Browser browser) {
        WebDriver driver;
        WebDriverManager.getInstance(browser.getDriverName()).setup();

        switch (browser) {
            case EDGE -> driver = new EdgeDriver();
            case FIREFOX -> driver = new FirefoxDriver();
            case SAFARI -> driver = new SafariDriver();
            default -> driver = new ChromeDriver();
        }

        int waitInSeconds = ConfigReader.getPropertyAsInt("defaultTimeOut");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitInSeconds));
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getWebDriver() {
        Browser browser = Browser.fromString(ConfigReader.getProperty("browser"));
        return getWebDriver(browser);
    }
}
