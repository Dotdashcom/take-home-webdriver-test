package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.ReadConfig;

public class LoginPage extends PageBase {
    @FindBy(xpath = "//*[@name='username']")
    protected WebElement username;

    @FindBy(xpath = "//*[@name='password']")
    protected WebElement password;

    @FindBy(xpath = "//*[@class='fa fa-2x fa-sign-in']")
    protected WebElement logInButton;

    @FindBy(xpath = "//*[@class='subheader']")
    protected WebElement successMessage;

    @FindBy(xpath = "//*[@id='flash']")
    protected WebElement errorMessage;

    public void LogIn(){
        driver.get(ReadConfig.getProperty("LoginSuccess"));
        BrowserUtils.waitForPageToLoad(5);
        username.sendKeys(ReadConfig.getProperty("logIn"));
        password.sendKeys(ReadConfig.getProperty("password"));
        logInButton.click();
        BrowserUtils.waitForVisibility(successMessage,5);
        String ExpectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String ActualMessage = successMessage.getText();
        Assert.assertEquals(ExpectedMessage,ActualMessage);

    }
    public void LogIn(String usName,String pwd){
        driver.get(ReadConfig.getProperty("LoginSuccess"));
        BrowserUtils.waitForPageToLoad(5);
        username.sendKeys(usName);
        password.sendKeys(pwd);
        logInButton.click();
        BrowserUtils.waitForVisibility(successMessage,5);
        String ExpectedMessage = "Your username is invalid!";
        String ActualMessage = errorMessage.getText().substring(0,errorMessage.getText().length()-2);
        Assert.assertEquals(ExpectedMessage,ActualMessage);

    }
}
