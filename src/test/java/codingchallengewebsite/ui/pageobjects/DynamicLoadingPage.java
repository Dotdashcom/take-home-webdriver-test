package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITests;
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

public class DynamicLoadingPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Dynamically Loaded Page Elements']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//button[text()= 'Start']")
    private WebElement startButton;
    @FindBy(how = How.XPATH, using = "//*[@id='finish']")
    private WebElement successMessage;
    private UITests caller;
    private final String pageUrl;
    public WebDriver driver;

    public DynamicLoadingPage(WebDriver driver, UITests caller) {
        this.caller = caller;
        this.driver = driver;
        this.pageUrl = new StringBuilder().append(DEFAULT_BASE_URL).append("/dynamic_loading/2").toString();
        this.driver.get(this.pageUrl);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpen() {
        return driver.getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().toString().contains("Dynamically Loaded Page Elements");
    }

    public void startMessageRequest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        startButton.click();
        wait.until(ExpectedConditions.visibilityOf(successMessage));
    }

    public String getSuccessMessage() {
        return successMessage.getText().toString();
    }





}
