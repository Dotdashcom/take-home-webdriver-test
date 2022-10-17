package Assignment;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop extends TestBase {


    @Test
    public void dragAndDropTest() throws InterruptedException {

        driver.get(baseUrl + "/drag_and_drop");


        WebElement columnA = driver.findElement(By.xpath("//div[@id='columns']//div[@id='column-a']"));
        WebElement columnB = driver.findElement(By.xpath("//div[@id='columns']//div[@id='column-b']"));


        getActions().dragAndDrop(columnB,columnA).perform();

        WebElement columnAHeaderB = driver.findElement(By.xpath("//div[@id='columns']//div[@id='column-a']/header"));


        Assert.assertEquals(columnAHeaderB.getText(), "B","Drag and Drop column A to B FAILED");
    }

    @Test
    public void dragAndDropTest2(){

        driver.get(baseUrl + "/drag_and_drop");


        WebElement columnA = driver.findElement(By.xpath("//div[@id='columns']//div[@id='column-a']"));
        WebElement columnB = driver.findElement(By.xpath("//div[@id='columns']//div[@id='column-b']"));


        getActions().dragAndDrop(columnA,columnB).perform();


        WebElement columnBHeaderA = driver.findElement(By.xpath("//div[@id='columns']//div[@id='column-b']/header"));


        Assert.assertEquals(columnBHeaderA.getText(), "A","Drag and Drop column A to B FAILED");
    }



}
