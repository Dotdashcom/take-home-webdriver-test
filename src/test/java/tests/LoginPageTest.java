package tests;

import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import core.BasePageTest;
import org.testng.asserts.SoftAssert;
import pages.LandingPage;
import pages.LoginPage;
import pages.SecurePage;
import utils.ConfigReader;


public class LoginPageTest extends BasePageTest {

    protected LoginPage loginPage;

    @BeforeMethod
    public void goToStartPage() {
        landingPage.navigateTo("login");
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @AfterMethod
    public void induceDelay() {
        sleepInSeconds(2);
    }

    @Test(priority = 0)
    public void validCredentialsTest(){
        loginPage.doLogin(ConfigReader.getAutProperty("loginUser"), ConfigReader.getAutProperty("loginPassword"));
        //Wait for login to be successful and for banner
        loginPage.waitForElementToBeClickable("#content > div > h2");

        SecurePage securePage = PageFactory.initElements(driver, SecurePage.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(securePage.getSuccessMessage().contains("You logged into a secure area!"));
        softAssert.assertEquals(securePage.getFlashBackgroundColor(), "rgba(93, 164, 35, 1)"); //Green background color
        softAssert.assertAll();
        securePage.doLogout();
    }

    @Test(priority = 1)
    public void emptyCredentialsTest(){
        loginPage.doLogin("", "");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.getErrorMessage().contains("Your username is invalid!"));
        softAssert.assertEquals(loginPage.getFlashBackgroundColor(), "rgba(198, 15, 19, 1)");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void wrongPasswordTest(){
        loginPage.navigateTo("login");
        loginPage.doLogin(ConfigReader.getAutProperty("loginUser"), "gsdfgsdg");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.getErrorMessage().contains("Your password is invalid!"));
        softAssert.assertEquals(loginPage.getFlashBackgroundColor(), "rgba(198, 15, 19, 1)");
        softAssert.assertAll();
    }
}