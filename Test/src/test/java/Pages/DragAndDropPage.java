package Pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends PageBase {

    @FindBy(xpath = "//div[@id='column-a']")
    WebElement boxA;

    @FindBy(xpath = "//div[@id='column-b']")
    WebElement boxB;

    public void dragBoxAtoBoxB(){
        BrowserUtils.dragAndDrop(boxA,boxB);
    }

    public int elementsLocationsDifference(){
        Point A = BrowserUtils.getElementLocation(boxA);
        Point B = BrowserUtils.getElementLocation(boxB);
        return A.x-B.x;
    }

}
