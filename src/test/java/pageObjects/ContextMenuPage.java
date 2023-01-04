package pageObjects;

import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContextMenuPage extends Page {
    private static final By CONTEXT_MENU_BOX = By.id("hot-spot");

    public ContextMenuPage(ChromeDriver driver) {
        super(driver);
    }

    public ContextMenuPage rightClickContextMenuBox() {
        WebElement contextMenuBox = elementToBeClickable(CONTEXT_MENU_BOX, BasePage.TIMEOUT);

        getActions()
                .contextClick(contextMenuBox)
                .build()
                .perform();

        return this;
    }

    public String getJavaScriptAlertText() {
        return getAlert(BasePage.TIMEOUT).getText();
    }
}
