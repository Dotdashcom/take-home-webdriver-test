package tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import pages.LoginPage;

public class TestLogin {



  private WebDriver driver;
  private LoginPage login;
  private String username = "tomsmith";
  private String password = "SuperSecretPassword!";


  private String usernameInvalid = "abctomsmith";
  private String passwordInvalid = "xyzSuperSecretPassword!";

  String successMsg = "You logged into a secure area!";


  @Before
  public void setup() {
    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    login = new LoginPage(driver);
  }

  @Test
  public void loginSuccess() {
    login.withCredentials(username, password);
    //Assert.assertTrue(successMsg);
    assertTrue("You logged into a secure area!", login.isValid());
  }

  @Test
  public void loginFailed() {
    login.withCredentials(usernameInvalid, passwordInvalid);
    //Assert.assertTrue(successMsg);
    assertTrue("LYour password is invalid!", login.isInvalid());
  }

  @After
  public void teardown() {
    driver.quit();
  }
}
