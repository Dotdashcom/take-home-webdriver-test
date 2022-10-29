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

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;

public class WindowsPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Opening a new window']")
    public WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Click Here']")
    public WebElement link;
    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='New Window']")
    public WebElement newTab;
    private final UITest caller;
    private final String pageUrl;

    public WindowsPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        //WebDriverWait pageFactoryInitWait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(10), Duration.ofSeconds(5));
        this.caller.setDriver(driver);
        this.pageUrl = this.caller.getBaseUrl() + "/windows";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
        this.caller.pageFactoryInitWait(pageTitle);
        //pageFactoryInitWait.until(ExpectedConditions.and(visibilityOf(this.pageTitle),presenceOfAllElementsLocatedBy(By.xpath("//a[normalize-space()='Click Here']"))));
    }

    public Boolean isPageOpen() { return this.caller.isPageOpen(this.pageUrl, this.pageTitle); }

    public void clickLink() {
        this.link.click(); }

    public Boolean validateNewTab() {
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(30));
        String originalWindow = caller.getDriver().getWindowHandle();
        String expectedMessage ="New Window";
        String newTabHandle;

        this.clickLink();
        wait.until(numberOfWindowsToBe(2));

        //Loop through until we find a new window handle
        for (String windowHandle : caller.getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                newTabHandle = windowHandle;
                caller.getDriver().switchTo().window(windowHandle);
                wait.until(titleIs("New Window"));
                return newTab.getText().equals(expectedMessage);
            }
        }
        return false;
    }
}