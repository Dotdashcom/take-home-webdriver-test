package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ContextMenuPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Context Menu']")
    public WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//div[@id='hot-spot']")
    public WebElement box;
    private final UITest caller;
    private Alert alertPopup;
    private final String pageUrl;
    private final String mainWindow;

    public ContextMenuPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        //WebDriverWait pageFactoryInitWait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(10), Duration.ofSeconds(5));
        this.caller.setDriver(driver);
        this.pageUrl = this.caller.getBaseUrl() + "/context_menu";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
        this.caller.pageFactoryInitWait(pageTitle);
        //pageFactoryInitWait.until(ExpectedConditions.and(visibilityOf(this.pageTitle),presenceOfAllElementsLocatedBy(By.xpath("//div[@id='hot-spot']"))));
        this.mainWindow = caller.getDriver().getWindowHandle();
    }

    public Boolean isPageOpen() { return this.caller.isPageOpen(this.pageUrl, this.pageTitle); }

    public void rightClickBox() {
        Actions builder = new Actions(caller.getDriver());
        builder.moveToElement(this.box).contextClick(this.box).perform();
    }
    public String getAlertPopupText() {
        String alertPopupText;

        this.alertPopup = caller.getDriver().switchTo().alert();
        alertPopupText = this.alertPopup.getText();
        caller.getDriver().switchTo().window(this.mainWindow);
        return alertPopupText;
    }

    public void closeAlertPopup() {
        caller.getDriver().switchTo().alert();
        this.alertPopup.accept();
        caller.getDriver().switchTo().window(this.mainWindow);
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }
}