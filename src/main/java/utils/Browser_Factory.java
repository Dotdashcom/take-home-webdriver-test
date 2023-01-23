package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Browser_Factory {
    static WebDriver driver;
    static String browser;
    static String BaseURL;


    public static WebDriver readConfig() {

        Properties prop = new Properties();

        try {
            InputStream input = new FileInputStream("src/main/java/configuration/configuration.properties");
            prop.load(input);
            browser = prop.getProperty("browser");
            System.out.println("Browser used :" + browser);
            BaseURL = prop.getProperty("BaseURL");
//            System.out.println("BaseURL used :" + BaseURL);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return driver;
    }
    public static WebDriver init_browser() {
        readConfig();
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }
    public static WebDriver init_url(String URI) {
        driver.get(BaseURL+ URI);
        System.out.println("URL used :" + BaseURL+ URI);
        return driver;
    }

    public static WebDriver teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
        return driver;
    }

}
