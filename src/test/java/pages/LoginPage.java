package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//h2")
    public WebElement headerTwo;

    @FindBy(xpath = "//h4")
    public WebElement headerFour;

    @FindBy(id = "flash")
    public WebElement failedLoginMsg;

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public String parseFailedLoginMessage(String actualHeaderMsg) {
        try {
            actualHeaderMsg = actualHeaderMsg.substring(actualHeaderMsg.indexOf('Y') , actualHeaderMsg.lastIndexOf('!') + 1);
        } catch (StringIndexOutOfBoundsException e) {
            Assert.fail("failed login message incorrect");
        }
        return actualHeaderMsg;
    }
}

