package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;


public class Test5DragAndDrop extends chromedriver {

    @Test
    public void Test5DragAndDrop() throws InterruptedException {
        String url = "http://localhost:7080/drag_and_drop";
        driver.get(url);

        By firstBox = By.xpath("//div[@id='columns']/div[@id='column-a']/header");
        By secondBox = By.xpath("//div[@id='columns']/div[@id='column-b']/header");

        WebElement boxA = driver.findElement(firstBox);
        WebElement boxB = driver.findElement(secondBox);
        String boxAText = boxA.getText();
        String boxBText = boxB.getText();
        Assert.assertEquals(boxAText,"A");
        Assert.assertEquals(boxBText,"B");

        Thread.sleep(2000);
        Actions dragDropAction= new Actions(driver);
        dragDropAction.dragAndDrop(boxA, boxB).perform();
        Thread.sleep(2000);

        WebElement boxAAfter = driver.findElement(firstBox);
        WebElement boxBAfter = driver.findElement(secondBox);
        String boxATextAfter = boxAAfter.getText();
        String boxBTextAfter = boxBAfter.getText();
        //Spent some time trying to figure out why dragAndDrop(a,b) was dragging element a to the
        //current location of my cursor instead of b. Turns out it is a know bug
        System.out.println("NOTE: Selenium DRAG AND DROP functionality is broken. A know bug");
        Assert.assertEquals(boxATextAfter,"B");
        Assert.assertEquals(boxBTextAfter,"A");
    }

}