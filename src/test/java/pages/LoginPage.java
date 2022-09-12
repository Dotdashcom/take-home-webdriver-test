package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

   public LoginPage() {
       url = "http://localhost:7080/login";
    }

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy (id = "password")
    private WebElement passwordField;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy (xpath = "//div[@id='flash']")
    private WebElement actualMes;

    public void filloutFields(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getMes() {
        String actualText = actualMes.getText();
        return actualText;
    }

}
