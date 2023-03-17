package com.Demo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object encapsulates the Sign-in page.
 */
public class SignInPage {
  protected WebDriver driver;

  // <input name="user_name" type="text" value="">
  private By usernameBy = By.id("username");
  // <input name="password" type="password" value="">
  private By passwordBy = By.id("password");
  // <input name="sign_in" type="submit" value="SignIn">
  private By signinBy = By.xpath(("//*[text()=' Login']"));
  

  public SignInPage(WebDriver driver){
    this.driver = driver;
     }
 
  /**
    * Login as valid user
    * @param userName
    * @param password
    * @return HomePage object
    */
  public HomePage loginValidUser(String userName, String password) {
	driver.get("http://localhost:7080/login"); 
	driver.findElement(usernameBy).sendKeys(userName);
    driver.findElement(passwordBy).sendKeys(password);
    driver.findElement(signinBy).click();
    return new HomePage(driver);
  }
}
