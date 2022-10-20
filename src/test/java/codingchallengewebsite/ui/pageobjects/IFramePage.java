package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITests;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static codingchallengewebsite.ui.UITests.DEFAULT_BASE_URL;
public class IFramePage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='An iFrame containing the TinyMCE WYSIWYG Editor']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//*[@id='mce_0_ifr']")
    private WebElement iFrame;
    @FindBy(how = How.XPATH, using = "//*[@id='tinymce']")
    private WebElement iFrameTextArea;
    private UITests caller;
    private final String pageUrl;
    public WebDriver driver;

    public IFramePage(WebDriver driver, UITests caller) {
        this.caller = caller;
        this.driver = driver;
        this.pageUrl = new StringBuilder().append(DEFAULT_BASE_URL).append("/iframe").toString();
        this.driver.get(this.pageUrl);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpen() {
        // Check that the page loaded
        return driver.getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().toString().contains("An iFrame containing the TinyMCE WYSIWYG Editor");
    }

    public WebDriver switchTo(String context) {
        String iFrameId = "mce_0_ifr";

        return switch (context) {
            case "iframe" -> this.driver.switchTo().frame(iFrameId);
            case "main" -> this.driver.switchTo().defaultContent();
            default -> null;
        };
    }

    public String getPageTitle() {
        return this.pageTitle.getText().toString();
    }

    public String getIFrameTextAreaText() {
        return this.iFrameTextArea.getText().toString();

    }

    public void writeIFrameTextAreaText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.iFrameTextArea.sendKeys(text);
        wait.until( d -> {
            Objects.equals(iFrameTextArea.getText().toString(), text);
            return true;
        });
    }

    public void clearIFrameTextAreaText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.iFrameTextArea.clear();
        wait.until( d -> {
            iFrameTextArea.getText().toString().isEmpty();
            return true;
        });
    }
}
