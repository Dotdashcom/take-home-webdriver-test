package com.assignments.pages;

import org.openqa.selenium.By;
import static com.assignments.enums.WaitStrategy.*;

public final class LoginPage extends BasePage {

  private final By userNameField = By.id("username");
  private final By passwordField = By.id("password");
  private final By loginButton = By.xpath("//i[@class='fa fa-2x fa-sign-in']");
  private final By logoutButton = By.xpath("//i[@class='icon-2x icon-signout']");

  private final By fl = By.xpath("//div[@id='flash']/preceding-sibling::text()");

  public boolean login(String userName, String password) {
    sendKeys(userNameField, userName, VISIBLE, "User Name Field");
    sendKeys(passwordField, password, VISIBLE, "Password Field");
    click(loginButton, CLICKABLE, "Login Button");
    //String c = getText(fl, VISIBLE,"");
    return isDisplayed(logoutButton, VISIBLE, "Logout Button");
  }
}
