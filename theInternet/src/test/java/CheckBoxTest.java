
import PageObjects.HomePage;
import library.BrowserFactory;
import library.Constants;
import library.Log;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.CheckBoxPage;

import java.io.IOException;

import static library.BrowserFactory.getBaseURL;


public class CheckBoxTest
{

     WebDriver driver;

    @BeforeClass
    public void launchDriver() throws IOException {
       driver = BrowserFactory.launchDriver();
       driver.get(getBaseURL());
    }

    @Test
    public void checkBoxesTest() {
        Log.startLog(this.getClass().getSimpleName());
        Log.info("started");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLink(Constants.HomePageConstants.CHECKBOX_LINKTEXT);
        CheckBoxPage checkboxpage = new CheckBoxPage(driver);
        checkboxpage.clickCheckBox1();
        checkboxpage.clickCheckBox2();
        checkboxpage.validateCheckBox1Selected() ;
        checkboxpage.validateCheckBox2Selected();
    }

    @AfterClass
    public void quitDriver(){
        if(driver!=null) {
            driver.quit();
        }
    }
}
