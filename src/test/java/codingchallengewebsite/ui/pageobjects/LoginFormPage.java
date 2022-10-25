package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class LoginFormPage {

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
    public UITest caller;
    private final String pageUrl;
    public String EXPECTED_LOGGED_IN_PAGE_URL;

    public LoginFormPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        this.caller.setDriver(driver);
        this.pageUrl = this.caller.getBaseUrl() + "/login";
        this.EXPECTED_LOGGED_IN_PAGE_URL = this.caller.getBaseUrl() + "/secure";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpen() {
        return Objects.equals(caller.getDriver().getCurrentUrl(), this.pageUrl) && this.pageTitle.getText().contains("Login Page"); }

    public void setUsername(String username) {
        WebDriverWait wait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(this.username));
        this.username.clear();
        this.username.sendKeys(username);
    }

    public void setPassword(String password) {
        WebDriverWait wait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(this.password));
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(this.loginButton));
        loginButton.click(); }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(this.loginButton));
        return errorMessage.getText(); }
}