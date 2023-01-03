import PageObjects.ContextPage;
import PageObjects.HomePage;
import library.BrowserFactory;
import library.Constants;
import library.PropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContextTest
{

    WebDriver driver;

    @BeforeClass
    public void launchDriver() throws IOException {
        driver = BrowserFactory.launchDriver();
        driver.get(PropertiesFileReader.getBaseURL());
    }


    @Test
    public void contextActionAlert() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLink(Constants.HomePageConstants.CONTEXT_LINKTEXT);
        ContextPage contextPage = new ContextPage(driver);
        contextPage.contextAction();
    }

    @AfterClass
    public void quitDriver(){
        if(driver!=null) {
            driver.quit();
        }
    }
}
