package homework.tests;

import homework.pages.DragAndDropPage;
import homework.test.TestBase;
import homework.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop extends TestBase {

    DragAndDropPage dragAndDrop=new DragAndDropPage();

    @Test
    public void dragAndDrop(){
        Driver.getDriver().get("http://localhost:7080/drag_and_drop");

        String boxA=dragAndDrop.columnA.getText();
        String boxB=dragAndDrop.columnB.getText();

        Actions actions=new Actions(Driver.getDriver());
        actions.dragAndDrop(dragAndDrop.columnA, dragAndDrop.columnB).perform();

        String boxA_afterDrag=dragAndDrop.columnA.getText();
        String boxB_afterDrag=dragAndDrop.columnB.getText();


    }
}
