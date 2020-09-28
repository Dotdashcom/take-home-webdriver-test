package pageobject;

import base.EndPointPath;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage {

    @FindBy(id = "hot-spot")
    private WebElement contextBox;

    public ContextMenuPage(WebDriver driver) {
        super(driver, EndPointPath.CONTEXT_MENU);
    }

    public void rightClickContextMenu() {
        Actions action = new Actions(driver);
        action.contextClick(contextBox).perform();
    }

    public boolean isDisplayAlert(){
        Alert alert = driver.switchTo().alert();
        boolean found = alert.getText().equals("You selected a context menu");
        alert.dismiss();
        return found;
    }


}
