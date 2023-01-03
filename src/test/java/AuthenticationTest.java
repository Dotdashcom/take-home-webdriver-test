import PageObjects.AuthenticationPage;
import PageObjects.HomePage;
import library.BrowserFactory;
import library.Constants;
import library.PropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AuthenticationTest
{
    WebDriver driver;

    @BeforeMethod
    public void launchDriver() throws IOException {
        driver = BrowserFactory.launchDriver();
        driver.get(PropertiesFileReader.getBaseURL());
    }

    @Test
    public void loginAuthenticationTest() {
        //Log.info(" **********Started : Login Authentication Test  *********************");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLink(Constants.HomePageConstants.AUTHENTICATION_LINKTEXT);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        String userName =   PropertiesFileReader.getUsername();
        String password = PropertiesFileReader.getPassword();
        Assert.assertTrue(authenticationPage.login(userName, password));
    }

    @Test
    public void invalidLogin(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLink(Constants.HomePageConstants.AUTHENTICATION_LINKTEXT);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        String userName =   PropertiesFileReader.getUsername();
        String password = PropertiesFileReader.getPassword();
        Assert.assertFalse(authenticationPage.login("abc", password));
        Assert.assertFalse(authenticationPage.login(userName, "abc"));
    }

    @AfterMethod
    public void quitDriver(){
        if(driver!=null) {
            driver.quit();
        }
    }
}
