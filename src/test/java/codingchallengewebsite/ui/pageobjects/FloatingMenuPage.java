package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FloatingMenuPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Floating Menu']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//*[@id='menu']")
    private WebElement menu;
    @FindBy(how = How.XPATH, using = "//body")
    private WebElement pageBody;
    @FindBy(how = How.XPATH, using = "//img[@alt='Fork me on GitHub']")
    private WebElement gitHubLogo;
    @FindBy(how = How.XPATH, using = "//*[@id='page-footer']/div/div/a")
    private WebElement elementalSeleniumLink;
    private UITest caller;
    private final String pageUrl;

    public FloatingMenuPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        this.caller.setDriver(driver);
        this.pageUrl = new StringBuilder(this.caller.getBaseUrl()).append("/floating_menu").toString();
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpen() {
        return this.caller.getDriver().getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().toString().contains("Floating Menu"); }

    public String getMenuPosition() {
        return menu.getAttribute("style"); }

    public void scrollToBottom() {
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(30));
        pageBody.sendKeys(Keys.END, Keys.CONTROL);
        pageBody.sendKeys(Keys.END, Keys.CONTROL);
        wait.until(ExpectedConditions.visibilityOf(elementalSeleniumLink));
    }

    public boolean validateMenuVisibility() {
        return menu.isDisplayed(); }
}