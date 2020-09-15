package framework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DragAndDropPage {

    WebDriver driver;
    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public void dragAndDropObject(){
        Actions actions = new Actions(driver);
        WebElement firstObject = driver.findElement(By.id("column-a"));
        WebElement secondObject = driver.findElement(By.id("column-b"));;
        String beforeDragText = firstObject.getText();
        actions.dragAndDrop(firstObject,secondObject).build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(beforeDragText, secondObject.getText());
    }
}
