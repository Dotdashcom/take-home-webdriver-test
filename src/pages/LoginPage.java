package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@class='radius']")
    public WebElement loginButton;

    @FindBy (xpath = "//div[@class = 'flash error']")
    public WebElement errorMessage;

    @FindBy (xpath = "//div[@class = 'flash success']")
    public WebElement successMessage;

    @FindBy (css = "a[class = 'button secondary radius']")
    public WebElement logoutButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

}
