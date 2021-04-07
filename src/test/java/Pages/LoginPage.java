package Pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath="//i[contains(text(),'Login')]")
    public WebElement loginButton;

    @FindBy(id="flash")
    public WebElement loginedInmessage;

    public void login(String uid, String pwd) {
        userName.sendKeys(uid);
        password.sendKeys(pwd);
        loginButton.click();
    }

}
