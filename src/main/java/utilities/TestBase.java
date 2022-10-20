package Utilities;

import Utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    private static Actions actions;

    private static WebDriverWait wait;

    public static WebDriver driver;
    public String baseUrl = "http://localhost:7080";



    public static WebDriverWait getWait() {
        if (wait == null)
            wait = new WebDriverWait(driver , 15);
        return wait;
    }


    public static Actions getActions() {
        if (actions == null)
            actions = new Actions(driver);
        return actions;
    }
    public static boolean JSLogsInfoTest(String expectedErrorMsg) {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            if (entry.getMessage().contains(expectedErrorMsg)) {
                return true;
            }
        }
        return false;
    }



    @BeforeMethod
    public  void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}