import PageObjects.DropDownPage;
import PageObjects.HomePage;
import library.BrowserFactory;
import library.Constants;
import library.PropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class DropDownTest
{

    WebDriver driver;

    @BeforeClass
    public void launchDriver() throws IOException {
        driver = BrowserFactory.launchDriver();
        driver.get(PropertiesFileReader.getBaseURL());
    }

    @Test
    public void dropDownHandle() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        homepage.clickOnLink(Constants.HomePageConstants.DROPDOWN_LINKTEXT);
        DropDownPage dropDownPage = new DropDownPage(driver);
        dropDownPage.dropDownActions();
    }


    @AfterClass
    public void quitDriver(){
        if(driver!=null) {
            driver.quit();
        }
    }
}
