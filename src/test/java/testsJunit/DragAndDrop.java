package testsJunit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import utils.Driver;

public class DragAndDrop extends BaseClass {
    //I am on the drag and drop page
    //I drag element A to element B

    @Test
    public void i_drag_element_A_to_element_B() throws InterruptedException {
        Driver.getDriver().get("http://localhost:7080/drag_and_drop");
        Driver.getDriver().manage().window().maximize();
        Actions action = new Actions(Driver.getDriver());
        WebElement source = Driver.getDriver().findElement(By.xpath("(//div[@draggable=\"true\"])[1]"));     //   "//div[@id='column-a']"));
        WebElement target = Driver.getDriver().findElement(By.xpath("(//div[@draggable=\"true\"])[2]"));
        //"//div[@id='column-b']"));
        int xOffset = source.getLocation().getX();
        int yOffset = target.getLocation().getY();
        System.out.println(xOffset + " " + yOffset);
        action.dragAndDropBy(source, xOffset, yOffset).build().perform();
        String texttarget = target.getText();
        if (texttarget.equals("A")) {
            Assert.assertTrue("Image switched", true);
        } else {
            System.out.println("Image is not switched");
        }
    }


}
