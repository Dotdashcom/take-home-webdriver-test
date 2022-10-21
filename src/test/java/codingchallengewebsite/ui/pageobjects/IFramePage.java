package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Objects;

public class IFramePage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='An iFrame containing the TinyMCE WYSIWYG Editor']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//*[@id='mce_0_ifr']")
    private WebElement iFrame;
    @FindBy(how = How.XPATH, using = "//*[@id='tinymce']")
    private WebElement iFrameTextArea;
    private final UITest caller;
    private final String pageUrl;

    public IFramePage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        this.caller.setDriver(driver);
        this.pageUrl = this.caller.getBaseUrl() + "/iframe";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpen() {
        // Check that the page loaded
        return caller.getDriver().getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().toString().contains("An iFrame containing the TinyMCE WYSIWYG Editor");
    }

    public WebDriver switchTo(String context) {
        String iFrameId = "mce_0_ifr";

        return switch (context) {
            case "iframe" -> caller.getDriver().switchTo().frame(iFrameId);
            case "main" -> caller.getDriver().switchTo().defaultContent();
            default -> null;
        };
    }

    public String getPageTitle() {
        return this.pageTitle.getText().toString(); }

    public String getIFrameTextAreaText() {
        return this.iFrameTextArea.getText().toString(); }

    public void writeIFrameTextAreaText(String text) {
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(30));
        this.iFrameTextArea.sendKeys(text);
        wait.until( d -> {
            Objects.equals(iFrameTextArea.getText().toString(), text);
            return true;
        });
    }

    public void clearIFrameTextAreaText() {
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(30));
        this.iFrameTextArea.clear();
        wait.until( d -> {
            iFrameTextArea.getText().toString().isEmpty();
            return true;
        });
    }
}