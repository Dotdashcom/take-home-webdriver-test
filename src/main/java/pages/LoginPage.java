package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    protected WebElement usernameInput;
    @FindBy(id = "password")
    protected WebElement passwordInput;
    @FindBy(css = "button[type=submit]")
    protected WebElement loginButton;
    @FindBy(id = "flash")
    protected WebElement getMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean loginSucess(String email, String password){
        usernameInput.clear();
        usernameInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
        return getMessage.getText().contains("You logged into a secure area!");
    }
    public boolean loginWithInvalidUsername(String username, String password){
        usernameInput.clear();
        usernameInput.sendKeys(username);
        usernameInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
        return getMessage.getText().contains("Your username is invalid!");
    }
    public boolean loginWithInvalidPassword(String username, String password){
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
        return getMessage.getText().contains("Your password is invalid!");
    }

    public String getSuccessMessage(){
        return  getMessage.getText();
    }
}
