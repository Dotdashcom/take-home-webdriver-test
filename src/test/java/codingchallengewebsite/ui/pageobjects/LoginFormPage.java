package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Objects;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginFormPage {

    @FindBy(how = How.XPATH, using = "//h2[normalize-space()='Login Page']")
    public WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//input[@id = 'username']")
    public WebElement username;
    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    public WebElement password;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement loginButton;
    @FindBy(how = How.XPATH, using = "//*[@class='flash error']")
    public WebElement errorMessage;
    private final UITest caller;
    private final String pageUrl;
    public String EXPECTED_LOGGED_IN_PAGE_URL;

    public LoginFormPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        //WebDriverWait pageFactoryInitWait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(10), Duration.ofSeconds(5));
        this.caller.setDriver(driver);
        this.pageUrl = this.caller.getBaseUrl() + "/login";
        this.EXPECTED_LOGGED_IN_PAGE_URL = this.caller.getBaseUrl() + "/secure";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
        this.caller.pageFactoryInitWait(pageTitle);
        //pageFactoryInitWait.until(ExpectedConditions.and(visibilityOf(this.pageTitle),visibilityOf(this.caller.getPageFooter())));
    }

    public Boolean isPageOpen() { return this.caller.isPageOpen(this.pageUrl, this.pageTitle); }

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