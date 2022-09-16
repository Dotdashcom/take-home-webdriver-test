package faridun.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    public static WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", "/Users/admin/take-home-webdriver-test/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://localhost:7080");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
