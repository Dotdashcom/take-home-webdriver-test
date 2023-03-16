package Pages;

import Tests.Utilities.ConfigurationReader;
import Tests.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id="username")
    public WebElement username;
    @FindBy(id="password")
    public WebElement password;
    @FindBy(css = "button[type='submit']")
    public WebElement loginBtn;
public LoginPage(){
    PageFactory.initElements(Driver.getDriver(), this);
}
public void login(){
    username.sendKeys(ConfigurationReader.getProperty("username"));
    password.sendKeys(ConfigurationReader.getProperty("password"));
    loginBtn.click();
}
}