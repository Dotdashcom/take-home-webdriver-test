package tests;

import Utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropTest {

    @BeforeTest
    public void setup(){
        Driver.setupDriver();
        Driver.getDriver().navigate().to("http://localhost:7080/drag_and_drop");
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(Driver.getDriver().findElement(By.id("column-a")), Driver.getDriver().findElement(By.id("column-b"))).build().perform();
        String elementAText = Driver.getDriver().findElement(By.id("column-a")).getText();
        String elementBText = Driver.getDriver().findElement(By.id("column-b")).getText();
        Assert.assertEquals(elementAText, "B");
        Assert.assertEquals(elementBText, "A");
    }


    @AfterTest
    public void done() {
        Driver.getDriver().quit();
    }
}
