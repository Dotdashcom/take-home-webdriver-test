package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static support.TestSetUp.getDriver;

public class ContextMenuPage extends BasePage {
    public ContextMenuPage() {
        url = "http://localhost:7080/context_menu";
    }

    @FindBy(id = "hot-spot")
    private WebElement box;

    public void rightClick() {
        Actions actions = new Actions(getDriver());
        actions.contextClick(box).perform();
    }

    public String getAlertText() {
        Alert alert = getDriver().switchTo().alert();
        String actualAlertText = alert.getText();
        return actualAlertText;
    }

}
