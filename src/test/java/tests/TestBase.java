package src.test.java.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverHelper;

public class TestBase {
    public WebDriver driver;
    protected String baseUrl = "http://localhost:7080";

    public TestBase() {
    }

    @BeforeMethod
    public void setup() {
        this.driver = DriverHelper.getDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        this.driver.quit();
    }
}
