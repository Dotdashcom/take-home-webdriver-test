package pageObjects;

import org.openqa.selenium.support.FindBy;
import utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#content > div > h2")
    public WebElement loginPageHeader;

    @FindBy(id = "username")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(css = "#login > button")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='flash error']")
    public WebElement loginErrorMessage;

    @FindBy(xpath = "//div[@class='flash success']")
    public WebElement loginSuccessMessage;
}
