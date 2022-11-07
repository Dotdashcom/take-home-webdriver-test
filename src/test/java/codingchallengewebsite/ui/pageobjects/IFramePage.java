package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class IFramePage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='An iFrame containing the TinyMCE WYSIWYG Editor']")
    public WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//*[@id='mce_0_ifr']")
    public WebElement iFrame;
    @FindBy(how = How.XPATH, using = "//*[@id='tinymce']")
    public WebElement iFrameTextArea;
    private final WebDriverWait genericWait;
    private final UITest caller;
    private final String pageUrl;

    public IFramePage(@NotNull UITest caller) {
        this.caller = caller;
        this.genericWait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(10));
        this.pageUrl = this.caller.getBaseUrl() + "/iframe";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(this.caller.getDriver(), this);
        this.caller.pageFactoryInitWait(pageTitle);
    }

    public Boolean isPageOpen() { return this.caller.isPageOpen(this.pageUrl, this.pageTitle); }

    public WebDriver switchTo(String context) {
        switch (context) {
            case "iframe" -> this.caller.getDriver().switchTo().frame(this.iFrame);
            case "main" -> this.caller.getDriver().switchTo().defaultContent();
        }
        return this.caller.getDriver();
    }

    public String getPageTitle() {
        return this.pageTitle.getText(); }

    public String getIFrameTextAreaText() {
        return this.iFrameTextArea.getText(); }

    public void writeIFrameTextAreaText(String text) {
        this.iFrameTextArea.sendKeys(text);
        this.genericWait.until(ExpectedConditions.textToBePresentInElement(iFrameTextArea, text));
    }

    public void clearIFrameTextAreaText() {
        this.iFrameTextArea.clear();
        genericWait.until( d -> iFrameTextArea.getText().isEmpty());
    }
}