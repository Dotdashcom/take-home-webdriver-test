package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.Constants;


public class DragDrop  extends Constants {

    static String url = "http://localhost:7080/drag_and_drop";


    @Test
    public static void testDragDrop() throws InterruptedException {
        driver.get(url);

        WebElement colA = driver.findElement(By.id("column-a"));
        WebElement colB = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);
        actions.moveToElement(colB).build().perform();
        Thread.sleep(1000);
        actions.clickAndHold(colA).moveToElement(colB).release().build().perform();
        Thread.sleep(500);
        String colAHeader = driver.findElement(By.xpath("//div[@id='column-a']//header")).getText();
        String colBHeader = driver.findElement(By.xpath("//div[@id='column-b']//header")).getText();

        sa.assertEquals(colAHeader, "B");
        sa.assertEquals(colBHeader, "A");

        sa.assertAll();



    }
}
