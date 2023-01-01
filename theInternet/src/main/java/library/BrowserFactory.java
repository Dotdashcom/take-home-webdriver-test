package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

public class BrowserFactory
{
    public static final String WORKING_DIR = System.getProperty("user.dir");
    public static final String DRIVER_PATH = WORKING_DIR + "/theInternet/src/resources/drivers/chromedriver.exe";

    public static WebDriver driver;

   public static String getBaseURL() throws IOException {
       return new PropertiesFileReader().readDataFromPropertiesFiles("baseURL");
   }

    public static WebDriver launchDriver() throws IOException {
        String browserName = new PropertiesFileReader().readDataFromPropertiesFiles("browser");
        switch(browserName){
            case "FireFox":
//                System.setProperty("driver.geckoDriver","DRIVER_PATH");
//                driver = new FireFoxDriver();
                break;
            case "CHROME" :
            case default:
                System.setProperty("driver.chromedriver",DRIVER_PATH);
                driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        return driver;
    }

}
