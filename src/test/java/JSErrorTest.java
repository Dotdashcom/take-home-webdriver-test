import PageObjects.HomePage;
import PageObjects.JSErrorPage;
import library.BrowserFactory;
import library.Constants;
import library.PropertiesFileReader;
import library.SeleniumLibrary;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static library.Constants.JSErrorConstants.ERROR_MESSAGE;

public class JSErrorTest {

    WebDriver driver;

    @BeforeClass
    public void launchDriver() throws IOException {
        driver = BrowserFactory.launchDriver();
        driver.get(PropertiesFileReader.getBaseURL());
    }

    @Test
    public void validateJSErrorMessages()  {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLink(Constants.HomePageConstants.JAVASCRIPT_ERROR_LINKTEXT);
        JSErrorPage jsErrorPage = new JSErrorPage(driver);
        SeleniumLibrary seleniumLibrary = new SeleniumLibrary();
       String actualMessage = seleniumLibrary.extractJSLogsInfo();
        Assert.assertTrue(actualMessage.contains(ERROR_MESSAGE));

    }

    @AfterClass
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
