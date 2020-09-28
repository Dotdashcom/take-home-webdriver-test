package pageobject;

import base.EndPointPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.FindBy;
import utilities.JavascriptUtilities;

import java.util.ArrayList;
import java.util.List;

public class OpenNewTabPage extends BasePage {

    @FindBy(xpath = "//a[@href='/windows/new']")
    private WebElement newTabLink;

    @FindBy(xpath = "//h3[contains(text(), 'New Window')]")
    private WebElement textInNewTab;
    private static final String NEW_TAB_TITLE = "New Window";

    public OpenNewTabPage(WebDriver driver) {
        super(driver, EndPointPath.WINDOWS);

    }


    public boolean verifyOpenNewTab() {
        //String currentPageHandle = driver.getWindowHandle();
        newTabLink.click();

        // Get all Open Tabs
        List<String> tabHandles = new ArrayList<>(driver.getWindowHandles());
        for (String tableTitle : tabHandles) {
            driver.switchTo().window(tableTitle);
            if (driver.getTitle().equalsIgnoreCase(NEW_TAB_TITLE) && textInNewTab.isDisplayed()) {
                return true;
            }
        }
        return false;

    }



}
