package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id="username")
    WebElement userNameInput;

    @FindBy(id="password")
    WebElement passwordInput;

    @FindBy(css="button[type='submit']")
    WebElement SubmitButton;

    @FindBy(id="flash")
    WebElement messageElem;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void login(String username, String password){
        super.typeText(userNameInput, username);
        super.typeText(passwordInput, password);
        super.click(SubmitButton);
    }

    public Boolean isLoginSuccessful() {
        return super.hasEndpoint("/secure") && super.elementHasClass(messageElem, "success");
    }

    public Boolean isLoginFailed() {
        return super.hasEndpoint("/login") && super.elementHasClass(messageElem, "error");
    }

}
