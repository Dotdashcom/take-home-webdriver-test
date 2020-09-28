package pageobject;

import base.EndPointPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;

    @FindBy(xpath = "//h4[contains(text(), 'Welcome to the Secure Area.')]")
    private WebElement labelAfterLoginSuccessfully;

    @FindBy(id = "flash")
    private WebElement loginError;

    public LoginPage(WebDriver driver) {
        super(driver, EndPointPath.LOGIN);
    }

    public void fillUsername(String username) {
        this.username.sendKeys(username);
    }

    public void fillPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickOnLogin(){
        this.submitBtn.click();
    }

    public void proceedLogin(String username, String password){
        fillUsername(username);
        fillPassword(password);
        clickOnLogin();
    }

    public boolean isLoginSuccessfully() {
        return this.labelAfterLoginSuccessfully.isDisplayed();
    }

    public boolean isLoginFail() {
        return this.loginError.isDisplayed();
    }
}
