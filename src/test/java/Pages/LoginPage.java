package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//*[contains (text(), 'You logged into a secure area!')]")
    public WebElement validLoginMessage;

    @FindBy(xpath = "//*[contains (text(), 'Your username is invalid!')]")
    public WebElement invalidLoginMessage;

}
