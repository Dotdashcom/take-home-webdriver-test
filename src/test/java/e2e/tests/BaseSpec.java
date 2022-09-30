package e2e.tests;

import helpers.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseSpec {
    final ConfigReader configReader = new ConfigReader();
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--ignore-certificate-errors");
        driver = new ChromeDriver(options);
    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }

}
