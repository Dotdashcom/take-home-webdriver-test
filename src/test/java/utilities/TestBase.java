package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    public static final String BASEURL = ConfigurationReader.getProperty("url");

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = Driver.getDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();


    }

//        @AfterClass(alwaysRun = true)
//        public void close(){
//            Driver.closeDriver();
//
//        }

    }

