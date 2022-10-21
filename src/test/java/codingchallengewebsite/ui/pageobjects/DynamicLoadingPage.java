package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DynamicLoadingPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Dynamically Loaded Page Elements']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//button[text()= 'Start']")
    private WebElement startButton;
    @FindBy(how = How.XPATH, using = "//*[@id='finish']")
    private WebElement successMessage;
    private UITest caller;
    private final String pageUrl;

    public DynamicLoadingPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        this.caller.setDriver(driver);
        this.pageUrl = new StringBuilder(this.caller.getBaseUrl()).append("/dynamic_loading/2").toString();
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpen() {
        return caller.getDriver().getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().toString().contains("Dynamically Loaded Page Elements");
    }

    public void startMessageRequest() {
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(30));
        startButton.click();
        wait.until(ExpectedConditions.visibilityOf(successMessage));
    }

    public String getSuccessMessage() {
        return successMessage.getText().toString();
    }
}