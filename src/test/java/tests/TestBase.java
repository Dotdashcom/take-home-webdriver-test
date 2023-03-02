package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.Driver;

public class TestBase {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = Driver.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Driver.closeDriver();
    }
}
