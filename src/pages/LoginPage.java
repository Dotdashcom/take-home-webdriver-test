package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.TestLoginSuccess;

import java.util.concurrent.TimeUnit;


public class LoginPage {
  private WebDriver driver;
  By userNameLoc  = By.id("username");
  By passwordLoc  = By.id("password");
  By submitButton= By.xpath("//*[@id='login']/button/i");

  By successMessageLoc=By.xpath("//*[@id='content']/div/h4");

  By failureMessageLoc = By.xpath("//*[@id=\'flash\']");


  public LoginPage(WebDriver driver) {
    this.driver = driver;
    driver.get("http://localhost:7080/login");

  }

  public void withCredentials(String username, String password) {
    driver.findElement(userNameLoc).sendKeys(username);

    driver.findElement(passwordLoc).sendKeys(password);
    driver.findElement(submitButton).click();

  }

  public Boolean isValid() {
    return driver.findElement(successMessageLoc).isDisplayed();
  }

  public Boolean isInvalid() {
    driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
    return driver.findElement(failureMessageLoc).isDisplayed();
  }
}
