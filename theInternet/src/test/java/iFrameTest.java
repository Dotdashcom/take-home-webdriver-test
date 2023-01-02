import PageObjects.HomePage;
import PageObjects.IFramePage;
import library.BrowserFactory;
import library.Constants;
import library.PropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class iFrameTest
{
    WebDriver driver;

    @BeforeClass
    public void launchDriver() throws IOException {
        driver = BrowserFactory.launchDriver();
        driver.get(PropertiesFileReader.getBaseURL());
    }

    @Test
    public void validateIFrame()  {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLink(Constants.HomePageConstants.FRAMES_LINKTEXT);
        IFramePage iFramePage = new IFramePage(driver);
        iFramePage.clickOniFrameLink();
        iFramePage.enterTextInTextArea(driver, "abc");
        Assert.assertTrue(   iFramePage.getTextfromTextarea(driver).contains("abc"));
    }


        @AfterClass
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
