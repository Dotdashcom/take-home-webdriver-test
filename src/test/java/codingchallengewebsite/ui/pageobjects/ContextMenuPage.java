package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITests;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;
import java.awt.event.KeyEvent;

import static codingchallengewebsite.ui.UITests.DEFAULT_BASE_URL;

public class ContextMenuPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Context Menu']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//div[@id='hot-spot']")
    private WebElement box;
    private final UITests caller;
    private Alert alertPopup;
    private final String pageUrl;
    private final String mainWindow;
    public WebDriver driver;

    public ContextMenuPage(WebDriver driver, UITests caller) {
        this.caller = caller;
        this.driver = driver;
        this.pageUrl = new StringBuilder().append(DEFAULT_BASE_URL).append("/context_menu").toString();
        driver.get(this.pageUrl);
        PageFactory.initElements(driver, this);
        this.mainWindow = this.driver.getWindowHandle();
    }

    public boolean isPageOpen() { return this.driver.getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().contains("Context Menu"); }

    public void rightClickBox() {
        Actions builder = new Actions(this.driver);
        builder.moveToElement(this.box).contextClick(this.box).perform();
    }
    public String getAlertPopupText() {
        String alertPopupText;

        this.alertPopup = this.driver.switchTo().alert();
        alertPopupText = this.alertPopup.getText();
        this.driver.switchTo().window(this.mainWindow);
        return alertPopupText;
    }

    public void closeAlertPopup() {
        Actions builder = new Actions(driver);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        this.driver.switchTo().alert();
        this.alertPopup.accept();
        this.driver.switchTo().window(this.mainWindow);
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
