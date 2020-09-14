package Pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends PageBase {

    @FindBy (xpath = "//div[@id='hot-spot']")
    WebElement hotspot;

    public void rightClickOnHotSpot(){
        BrowserUtils.rightClick(hotspot);
    }


}
