package runner;

import base.TestBase;

import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.DriverUtil;
import utilities.PropertiesReadingUtil;

import static org.testng.Assert.fail;

public class InvalidLoginTest extends TestBase {
  LoginPage loginPage = new LoginPage();

  @Test
  public void invalidLogin() {
    DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("baseUrl") + "login");
    loginPage.inValidLogin();
    String errorMsg = loginPage.invalidLoginMsg();
    String expErrorMsg = "Your username is invalid!\n" + "�";
    //Assert.assertEquals(errorMsg,expErrorMsg);
    if (!errorMsg.contains("Your username is invalid!")) {
      fail();
    }


  }
}
