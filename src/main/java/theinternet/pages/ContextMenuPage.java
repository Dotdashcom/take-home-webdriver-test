package theinternet.pages;

import jdk.jfr.Threshold;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage extends BasePage{
    Actions actions;
    public ContextMenuPage() {
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }
    @FindBy(xpath = "//h3[contains(.,'Context Menu')]")
    public WebElement contextMenuPageHeader;
    @FindBy(xpath = "//p[contains(.,'Context menu items are custom additions that appear in the right-click menu.')]")
    public WebElement contextMenuPageSubHeader;
    @FindBy(xpath = "//div[contains(@oncontextmenu,'displayMessage()')]")
    public WebElement contextMenuPageBox;

    public Boolean validatePageLanding(){
        contextMenuPageHeader.isDisplayed();
        contextMenuPageSubHeader.isDisplayed();
        contextMenuPageBox.isDisplayed();
        return true;
    }
    public String alertTest() throws InterruptedException {
        actions.contextClick(contextMenuPageBox).perform();
        Thread.sleep(2000);
        return driver.switchTo().alert().getText();
    }

    public Boolean closeAlert() throws InterruptedException {
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        return true;
    }

}
