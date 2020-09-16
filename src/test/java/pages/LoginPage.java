package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    public WebElement usernameElement;

    @FindBy(id = "password")
    public WebElement passwordElement;

    @FindBy(tagName = "button")
    public WebElement submitBtn;

    @FindBy(tagName = "h4")
    public WebElement successMessage;

    @FindBy(id = "flash")
    public WebElement errorMessage;

    public void login(String username, String password) {
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        submitBtn.click();
    }
}
