package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}



    private static WebDriver driver;


    public static WebDriver getDriver(){
        if(driver==null){

            String browserType= ConfigurationReader.getProperty("browser");

            if ("chrome".equals(browserType)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver!= null){
            driver.quit();
            driver=null;
        }
    }
}
