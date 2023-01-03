import PageObjects.HomePage;
import PageObjects.JSAlertPage;
import library.BrowserFactory;
import library.Constants;
import library.PropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class JSAlertTest {

    WebDriver driver;

    @BeforeClass
    public void launchDriver() throws IOException {
        driver = BrowserFactory.launchDriver();
        driver.get(PropertiesFileReader.getBaseURL());
    }

    @Test
    public void validateAlerts() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLink(Constants.HomePageConstants.JAVASCRIPT_ALERT_LINKTEXT);
        JSAlertPage jsAlertPage = new JSAlertPage(driver);
        jsAlertPage.validateAlerts();
      Assert.assertTrue( jsAlertPage.getResultText().contains("abc"));
    }

    @AfterClass
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
