package methods;

import model.ContextMenuPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuMethod extends GeneralTestMethod{

    private final String contextMenuURL = "http://localhost:7080/context_menu";
    ContextMenuPage contextMenuPage;

    public void startContextMenuTest() {
        driver.get(contextMenuURL);
        contextMenuPage = new ContextMenuPage(driver);
        rightClick(contextMenuPage.contextMenuComponent());

    }

    public void rightClick(WebElement contextMenu) {
        Actions action = new Actions(driver);
        action.contextClick(contextMenu).build().perform();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }


}
