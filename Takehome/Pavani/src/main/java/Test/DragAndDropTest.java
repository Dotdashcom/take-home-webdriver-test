package Test;

import Utilities.DriverHelper;
import Main.DragAndDropPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest {

    DragAndDropPage dragAndDrop= new DragAndDropPage();

    @Test
    public void Switch () throws InterruptedException {

        DriverHelper.getDriver().get("http://localhost:7080/drag_and_drop");

        DriverHelper.getDriver().manage().window().maximize();

        Actions actions = new Actions(DriverHelper.getDriver());



        actions.clickAndHold(dragAndDrop.FirstColumn).moveToElement(dragAndDrop.SecondColumn).release().build().perform();



        Thread.sleep(4000);

        System.out.println(dragAndDrop.FirstColumn.getText());

        Thread.sleep(4000);

        Assert.assertEquals(dragAndDrop.SecondColumn.getText(),"B");

        Assert.assertEquals(dragAndDrop.FirstColumn.getText(),"A");

        DriverHelper.closeDriver();

    }



}
