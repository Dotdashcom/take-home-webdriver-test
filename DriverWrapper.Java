package test_scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DriverWrapper {

    private static WebDriver driver;
    //private static String localUrl = "http://localhost:7080/";
    @BeforeClass
    public void beforeClass() {
        //setChromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");
        driver = new ChromeDriver();
        //navigate to the url
        //driver.navigate().to(localUrl+"login");

    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        //Thread.sleep(500);
        //driver.quit();
       // driver.manage().deleteAllCookies();
    }

    public static WebDriver getDriver() {
        return driver;
    }
    
}
