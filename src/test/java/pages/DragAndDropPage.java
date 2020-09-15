package pages;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;

public class DragAndDropPage extends PageBase {

    @FindBy(xpath = "//*[@id='column-a']")
    protected WebElement columnA;

    @FindBy(xpath = "//*[@id='column-b']")
    protected WebElement columnB;


    public void dragAndDrop(){
        BrowserUtils.dragAndDrop(columnA,columnB);
    }
    public int elementsLocationsDifference(){
        Point A = BrowserUtils.getElementLocation(columnA);
        Point B = BrowserUtils.getElementLocation(columnB);
        return A.x-B.x;
    }
}
