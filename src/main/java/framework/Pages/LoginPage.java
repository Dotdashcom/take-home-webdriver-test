package framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id ="username")
    WebElement userNameField;

    @FindBy(id ="password")
    WebElement passwordField;

    @FindBy(xpath ="//*[@id='login']/button")
    WebElement loginButton;

    @FindBy(id = "flash")
    WebElement loginErrorAlert;

    public void login(String username, String password) {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void verifyLoginFailure(){
        Assert.assertEquals(true, loginErrorAlert.isDisplayed());
    }

}
