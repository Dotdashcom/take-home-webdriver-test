package codingchallengewebsite.ui.pageobjects;


import codingchallengewebsite.ui.UITests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.Objects;

import static codingchallengewebsite.ui.UITests.DEFAULT_BASE_URL;

public class LoginPage {


    @FindBy(how = How.XPATH, using = "//h2[normalize-space()='Login Page']")
    private WebElement pageTitle;

    @FindBy(how = How.XPATH, using = "//input[@id = 'username']")
    private WebElement username;

    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[@class='flash error']")
    private WebElement errorMessage;
    private UITests caller;
    private final String pageUrl;
    public WebDriver driver;

    public LoginPage(WebDriver driver, UITests caller) {
        this.caller = caller;
        this.driver = driver;
        this.pageUrl = new StringBuilder().append(DEFAULT_BASE_URL).append("/login").toString();
        this.driver.get(this.pageUrl);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpen() {
        return Objects.equals(driver.getCurrentUrl(), this.pageUrl) && this.pageTitle.getText().toString().contains("Login Page"); }

    public void setUsername(String username) {
        this.username.clear();
        this.username.sendKeys(username);
    }

    public void setPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
