package theInternet.tests;

import theInternet.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        // we centralize our driver
        driver= Driver.getDriver();
        driver.get("http://localhost:7080");

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }



}
