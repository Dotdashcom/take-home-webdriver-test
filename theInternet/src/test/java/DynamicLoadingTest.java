import PageObjects.DynamicLoadedPage;
import PageObjects.DynamicLoadingPage;
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

public class DynamicLoadingTest
{

    WebDriver driver;

    @BeforeClass
    public void launchDriver() throws IOException {
        driver = BrowserFactory.launchDriver();
        driver.get(PropertiesFileReader.getBaseURL());
    }
    @Test
    public void dynamicLoadingHandle() throws InterruptedException
    {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLink(Constants.HomePageConstants.DYNAMIC_LOADING_LINKTEXT);
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingPage.clickHiddenElement();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        DynamicLoadedPage dynamicLoadedPage = new DynamicLoadedPage(driver);
        dynamicLoadedPage.clickStartButton();
        Thread.sleep(5000);
        String actualText = dynamicLoadedPage.getTextforHelloWorld();
        Assert.assertEquals(actualText , Constants.DynamicLoadConstants.DYNAMIC_LOAD_TEXT);

    }

    @AfterClass
    public void quitDriver(){
        if(driver!=null) {
            driver.quit();
        }
    }
}
