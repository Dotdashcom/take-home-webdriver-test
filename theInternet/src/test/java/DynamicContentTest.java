import PageObjects.DynamicContentPage;
import PageObjects.HomePage;
import library.BrowserFactory;
import library.Constants;
import library.PropertiesFileReader;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class DynamicContentTest
{

    WebDriver driver;

    @BeforeClass
    public void launchDriver() throws IOException {
        driver = BrowserFactory.launchDriver();
        driver.get(PropertiesFileReader.getBaseURL());
    }

    @Test
    public void dynamicContentHandle()
    {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLink(Constants.HomePageConstants.DYNAMIC_CONTENT_LINKTEXT);
        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
        String beforePage =dynamicContentPage.dynamicContentActions();
        dynamicContentPage.clickHereLink();
        String afterPage = dynamicContentPage.dynamicContentActions();
        Assert.assertNotEquals(beforePage,afterPage);
    }

    @AfterClass
    public void quitDriver(){
        if(driver!=null) {
            driver.quit();
        }
    }
}
