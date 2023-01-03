import PageObjects.CheckBoxPage;
import PageObjects.HomePage;
import library.BrowserFactory;
import library.Constants;
import library.Log;
import library.PropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class CheckBoxTest
{

     WebDriver driver;

    @BeforeClass
    public void launchDriver() throws IOException {
       driver = BrowserFactory.launchDriver();
       driver.get(PropertiesFileReader.getBaseURL());
    }

    @Test
    public void checkBoxesTest() {
        Log.startLog(this.getClass().getSimpleName());
        Log.info("started");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLink(Constants.HomePageConstants.CHECKBOX_LINKTEXT);
        CheckBoxPage checkboxpage = new CheckBoxPage(driver);
        checkboxpage.clickCheckBox1();
        Assert.assertTrue( checkboxpage.validateCheckBox1Selected()) ;
        checkboxpage.clickCheckBox2();
        Assert.assertFalse( checkboxpage.validateCheckBox2Selected());
        checkboxpage.clickCheckBox1();
        Assert.assertFalse( checkboxpage.validateCheckBox1Selected()) ;
        checkboxpage.clickCheckBox2();
        Assert.assertTrue( checkboxpage.validateCheckBox2Selected());

    }

    @AfterClass
    public void quitDriver(){
        if(driver!=null) {
            driver.quit();
        }
    }
}
