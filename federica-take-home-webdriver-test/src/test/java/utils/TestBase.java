package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    public static WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver=Driver.getDriver();
    }

    @AfterTest
    public void tearDown(){
        Driver.closeDriver();
    }
}
