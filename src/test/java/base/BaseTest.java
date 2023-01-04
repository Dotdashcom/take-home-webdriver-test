package base;

import constants.FilePaths;
import org.testng.annotations.*;
import pageObjects.HomePage;
import utils.ConfigReader;
import utils.DriverFactory;
import java.time.Duration;

public abstract class BaseTest {
    protected HomePage homePage;

    @BeforeSuite
    public void suiteSetup() {
        ConfigReader.readProperties(FilePaths.TEST_CONFIG + "test-config.properties");
    }

    @BeforeMethod
    public void testSetup() {
        DriverFactory.setDriver(ConfigReader.getMode());

        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().manage().deleteAllCookies();
        DriverFactory.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        DriverFactory.getDriver().get(ConfigReader.getBaseUrl());
        homePage = new HomePage(DriverFactory.getDriver());
    }

    @AfterMethod(alwaysRun = true)
    public void testTeardown() {
        if(DriverFactory.getDriver() != null) {
            DriverFactory.getDriver().quit();
            DriverFactory.removeDriver();
        }
    }
}
