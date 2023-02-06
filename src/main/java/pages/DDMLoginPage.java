package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DDMLoginPage extends DDMBasePage  {

    @FindBy(css = "[id='username']")
    protected WebElement usernameInput;

    @FindBy(css = "[id='password']")
    protected WebElement passwordInput;

    @FindBy(css = "button[type=submit]")
    protected WebElement loginButton;

    @FindBy(css = "[id='flash']")
    protected WebElement getMessage;

    public DDMLoginPage(WebDriver driver)  {
        super(driver);
    }

    public void performLogin(String email, String password)  {
        usernameInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getLoginResultMessage()  {
        return getMessage.getText();
    }
}