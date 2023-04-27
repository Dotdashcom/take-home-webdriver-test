package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(
            xpath = "//input[@id = 'username']"
    )
    WebElement username;
    @FindBy(
            xpath = "//input[@id = 'password']"
    )
    WebElement password;
    @FindBy(
            xpath = "//div[@id = 'flash']"
    )
    WebElement successMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getSuccessMessage() {
        return this.successMessage;
    }

    public void login(String userName, String passWord) {
     username.sendKeys(userName);
     password.sendKeys(passWord);
    }
}
