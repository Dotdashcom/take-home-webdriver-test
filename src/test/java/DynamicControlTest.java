import PageObjects.DynamicControlPage;
import PageObjects.HomePage;
import library.BrowserFactory;
import library.Constants;
import library.PropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class DynamicControlTest
{

    WebDriver driver;

    @BeforeClass
    public void launchDriver() throws IOException {
        driver = BrowserFactory.launchDriver();
        driver.get(PropertiesFileReader.getBaseURL());
    }
@Test
    public void dynamicControlHandle() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLink(Constants.HomePageConstants.DYNAMIC_CONTROLS_LINKTEXT);
        DynamicControlPage dynamicControlPage = new DynamicControlPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       Assert.assertTrue( dynamicControlPage.dynamicControlClickRemoveButton());
        Assert.assertTrue(dynamicControlPage.dynamicControlClickAddButton());
        Assert.assertFalse(dynamicControlPage.dynamicControlEnableButton());
      Assert.assertTrue(dynamicControlPage.dynamicControlDisableButton());
    }

    @AfterClass
    public void quitDriver(){
        if(driver!=null) {
            driver.quit();
        }
    }
}
