package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonMethods;
@Test
public class DragAndDropTest extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        setUp("http://localhost:7080/drag_and_drop");

        WebElement colomn1 = driver.findElement(By.id("column-a"));
        WebElement colomn2 = driver.findElement(By.id("column-b"));

        Actions action = new Actions(driver);

        action.clickAndHold(colomn1).moveToElement(colomn2).release().build().perform();

        String actualBoxText = colomn1.getText();
        String expectedBoxText = "B";

        //comparing text on boxes
        Assert.assertEquals(actualBoxText, expectedBoxText, "The test is failed. The text on element A and is not switched");
        System.out.println("The test is passed. The text on element A and B is switched");

         tearDown();
    }
}
