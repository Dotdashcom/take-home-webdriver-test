package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigurationReader;

public class LoginPage extends BasePage{
    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//i[@class='fa fa-2x fa-sign-in']")
    public WebElement loginButton;

    @FindBy(tagName = "h4")
    public WebElement sMessage;

    @FindBy(xpath = "//*[contains(text(),'Your username is invalid!')]")
    public WebElement fMessage;

    public void login(String userName, String passWord){
        username.sendKeys(userName);
        password.sendKeys(passWord);
        loginButton.click();
    }

    public void successfulLogin(){
        username.sendKeys(ConfigurationReader.getProperty("realUserName"));
        password.sendKeys(ConfigurationReader.getProperty("realPassWord"));
        loginButton.click();
    }

    public void failedLogin(){
        username.sendKeys("mehmet");
        password.sendKeys("sifre");
        loginButton.click();
    }

    public String getSuccessMessage(){
        return sMessage.getText();
    }

    public String getFailedMessage(){
        return fMessage.getText();
    }
}
