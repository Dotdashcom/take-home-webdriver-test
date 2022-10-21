package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;
import java.awt.event.KeyEvent;

public class ContextMenuPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Context Menu']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//div[@id='hot-spot']")
    private WebElement box;
    private final UITest caller;
    private Alert alertPopup;
    private final String pageUrl;
    private final String mainWindow;

    public ContextMenuPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        this.caller.setDriver(driver);
        this.pageUrl = new StringBuilder(this.caller.getBaseUrl()).append("/context_menu").toString();
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
        this.mainWindow = caller.getDriver().getWindowHandle();
    }

    public boolean isPageOpen() { return caller.getDriver().getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().contains("Context Menu"); }

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
        Actions builder = new Actions(caller.getDriver());

        caller.getDriver().switchTo().alert();
        this.alertPopup.accept();
        caller.getDriver().switchTo().window(this.mainWindow);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }
}