package runner;

import base.TestBase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverUtil;
import utilities.PropertiesReadingUtil;

public class ValidLoginTests extends TestBase {

  LoginPage loginPage = new LoginPage();
  HomePage homePage = new HomePage();

  @Test(priority = 1)
  public void validLogin() {
    DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("baseUrl") + "login");
    loginPage.validLogin();

    Assert.assertTrue(homePage.logoutButtonIsVisible());
    String actualUrl = homePage.getUrl();
    String expectedUrl = "http://localhost:7080/secure";
    Assert.assertEquals(actualUrl, expectedUrl);
    String welcomeMsg = "Welcome to the Secure Area. When you are done click logout below.";
    Assert.assertEquals(homePage.getText(), welcomeMsg);
    System.out.println(homePage.getText());


  }

}
