import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class ContextMenuPage extends PageObject
{
    //Elements
    @FindBy(id = "hot-spot")
    public WebElement RCElement;

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public void RightClick()
    {
        Actions Action = new Actions(driver);
        Action.contextClick(RCElement).perform();
    }
}
