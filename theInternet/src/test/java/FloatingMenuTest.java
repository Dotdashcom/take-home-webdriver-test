import PageObjects.FloatingMenuPage;
import PageObjects.HomePage;
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

public class FloatingMenuTest {

    WebDriver driver;

    @BeforeClass
    public void launchDriver() throws IOException {
        driver = BrowserFactory.launchDriver();
        driver.get(PropertiesFileReader.getBaseURL());
    }

    @Test
    public void validateFloatingMenu() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLink(Constants.HomePageConstants.FLOATING_MENU_LINKTEXT);
        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
        Assert.assertTrue(floatingMenuPage.isMenuDisplayed());
        new SeleniumLibrary().scrolldown();
        Assert.assertTrue(floatingMenuPage.isMenuDisplayed());
    }

    @AfterClass
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

