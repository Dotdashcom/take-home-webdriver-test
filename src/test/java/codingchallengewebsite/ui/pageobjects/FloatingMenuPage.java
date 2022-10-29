package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class FloatingMenuPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Floating Menu']")
    public WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//*[@id='menu']")
    public WebElement menu;
    @FindBy(how = How.XPATH, using = "//body")
    public WebElement pageBody;
    @FindBy(how = How.XPATH, using = "//img[@alt='Fork me on GitHub']")
    public WebElement gitHubLogo;
    @FindBy(how = How.XPATH, using = "//*[@id='page-footer']/div/div/a")
    public WebElement elementalSeleniumLink;
    private final UITest caller;
    private final String pageUrl;

    public FloatingMenuPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        //WebDriverWait pageFactoryInitWait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(10), Duration.ofSeconds(5));
        this.caller.setDriver(driver);
        this.pageUrl = new StringBuilder(this.caller.getBaseUrl()).append("/floating_menu").toString();
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
        this.caller.pageFactoryInitWait(pageTitle);
        //pageFactoryInitWait.until(ExpectedConditions.and(visibilityOf(this.pageTitle),presenceOfAllElementsLocatedBy(By.xpath("//*[@id='menu']"))));
    }

    public Boolean isPageOpen() { return this.caller.isPageOpen(this.pageUrl, this.pageTitle); }

    public String getMenuPosition() {
        return menu.getAttribute("style"); }

    public void scrollToBottom() {
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(30));
        pageBody.sendKeys(Keys.END, Keys.CONTROL);
        pageBody.sendKeys(Keys.END, Keys.CONTROL);
        wait.until(ExpectedConditions.visibilityOf(elementalSeleniumLink));
    }

    public Boolean validateMenuVisibility() {
        return menu.isDisplayed(); }
}