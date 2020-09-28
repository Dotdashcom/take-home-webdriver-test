package pageobject;

import base.EndPointPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import utilities.WaitUtilities;



public class DragAndDropPage extends BasePage {

    @FindBy(id = "column-a")
    private WebElement columnA;
    @FindBy(id = "column-b")
    private WebElement columnB;

    public DragAndDropPage(WebDriver driver) {
        super(driver, EndPointPath.DRAG_AND_DROP);
    }

    public void dragAndDropAToB() {

        //Cannot run by Chrome
        //Utilities.dragAndDropElementByAction(driver, columnA, columnB);

        //Use Robot framework
        WaitUtilities.dragAndDropElementByRobot(columnA, columnB);

    }

    public boolean verifyTextSwitched() {
        String textInSource = columnA.getText();
        System.out.println(textInSource);
        String textInDestination = columnB.getText();
        System.out.println(textInDestination);
        return textInSource.equals("B") && textInDestination.equals("A");

    }



}
