package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonMethods;
@Test
public class ContextMenuTest extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        {
            setUp("http://localhost:7080/context_menu");

            WebElement box = driver.findElement(By.id("hot-spot"));
            Actions action = new Actions(driver);
            action.contextClick(box).perform();

            Alert alert = driver.switchTo().alert(); //switch focus to the alert
            String expectedAlertText = "You selected a context menu";
            String actualAlertText = alert.getText();

            Assert.assertEquals(actualAlertText,expectedAlertText, "The test is failed. The alert menu text is not displayed");
            System.out.println("The test is passed. The alert menu text is displayed");

            alert.accept();

        }
        tearDown();
    }
}

