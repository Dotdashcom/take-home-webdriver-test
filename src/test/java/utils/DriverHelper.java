//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class DriverHelper {
    public static WebDriver driver;

    private DriverHelper() {
    }

    public static WebDriver getDriver() {
        if (driver == null || ((RemoteWebDriver)driver).getSessionId() == null) {
            switch (ConfigReader.readProperty("browser")) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                default -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        }

        return driver;
    }
}
