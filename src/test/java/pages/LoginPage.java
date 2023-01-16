package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.PropertiesReadingUtil;

public class LoginPage extends BasePage {

  @FindBy(xpath = "//input[@id='username']")
  public WebElement usernameField;
  @FindBy(css ="#password")
  public WebElement passwordField;
  @FindBy(xpath = "//i[contains(text(),'Login')]")
  public WebElement loginButton;
  @FindBy(xpath = "//div[@id='flash']")
  public WebElement errorMsg;

  public void validLogin(){
   usernameField.sendKeys(PropertiesReadingUtil.getProperties("username"));
   passwordField.sendKeys(PropertiesReadingUtil.getProperties("password"));
   loginButton.click();
  }
  public void inValidLogin(){
    usernameField.sendKeys(PropertiesReadingUtil.getProperties("invalidUserName"));
    passwordField.sendKeys(PropertiesReadingUtil.getProperties("invalidPassword"));
    loginButton.click();
  }
  public String invalidLoginMsg(){
    return errorMsg.getText();
  }

}
