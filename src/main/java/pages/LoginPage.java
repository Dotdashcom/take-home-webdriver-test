package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='radius']")
    private WebElement loginButton;

    @FindBy(id = "flash")
    private WebElement loginMessage;

    public void login(String userName, String password) {
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getLoginMessage() {
        return loginMessage.getText();
    }
}
