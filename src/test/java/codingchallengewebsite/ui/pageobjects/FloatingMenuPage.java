package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITests;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static codingchallengewebsite.ui.UITests.DEFAULT_BASE_URL;

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
    private UITests caller;
    private final String pageUrl;
    public WebDriver driver;

    public FloatingMenuPage(WebDriver driver, UITests caller) {
        this.caller = caller;
        this.driver = driver;
        this.pageUrl = new StringBuilder().append(DEFAULT_BASE_URL).append("/floating_menu").toString();
        this.driver.get(this.pageUrl);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpen() {
        return this.driver.getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().toString().contains("Floating Menu");
    }

    public String getMenuPosition() {
        return menu.getAttribute("style");
    }

    public void scrollToBottom() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        pageBody.sendKeys(Keys.END, Keys.CONTROL);
        pageBody.sendKeys(Keys.END, Keys.CONTROL);
        wait.until(ExpectedConditions.visibilityOf(elementalSeleniumLink));
    }

    public boolean validateMenuVisibility() {
        return menu.isDisplayed();
    }

}
