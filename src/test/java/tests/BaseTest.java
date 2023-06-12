package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    private String url;
    private Properties prop;

    @BeforeMethod
    public void setup() throws IOException {
        prop = new Properties();
        FileInputStream file = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/config.properties");
        prop.load(file);

        if (prop.getProperty("browser").equals("chrome")) {
            ChromeOptions Option = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(Option);
        } else if (prop.getProperty("browser").equals("firefox")) {
            FirefoxOptions Option = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(Option);
        }else{
            EdgeOptions Option = new EdgeOptions();
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(Option);
        }
        String url=prop.getProperty("url");
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
