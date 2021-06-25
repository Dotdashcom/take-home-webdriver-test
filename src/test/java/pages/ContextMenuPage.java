package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage{

    @FindBy(id = "hot-spot")
    public WebElement hotSpot;

    public void rightClickOnHotSpot(){
        Actions rightClick = new Actions(driver);
        rightClick.contextClick(hotSpot).perform();
    }


}
