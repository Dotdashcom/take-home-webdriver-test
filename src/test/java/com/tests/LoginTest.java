package com.tests;

import com.assignments.pages.HomePage;
import com.assignments.pages.LoginPage;
import org.testng.annotations.Test;

import static com.assignments.constants.LinkNameConstants.LOGIN;
import static com.assignments.enums.ConfigProperties.*;
import static com.assignments.utils.PropertyUtils.getValue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public final class LoginTest extends BaseTest {

  /**
   * Private constructor for avoiding external instantiation.
   */
  private LoginTest() {

  }
  @Test(description = "Validate correct Login credential let the user sign in",
          testName = "Login Credentials Validation")
  public void validCredentialLoginTest() {
    new HomePage().clickOnLink(LOGIN);
    assertTrue(new LoginPage().login(getValue(USERNAME), getValue(PASSWORD)));
  }

  @Test(description = "Validate incorrect Login credential does not let the user sign in",
          testName = "Login Credentials Validation")
  public void invalidCredentialLoginTest() {
    new HomePage().clickOnLink("Form Authentication");
    assertFalse(new LoginPage().login("random", getValue(PASSWORD)));
  }
}
