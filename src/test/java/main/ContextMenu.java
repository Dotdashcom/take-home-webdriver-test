package main;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Constants;

import javax.swing.*;

public class ContextMenu extends Constants {

    static String url = "http://localhost:7080/context_menu";


    @Test
    public static void testContextMenu() {
        driver.get(url);

        WebElement hotSpot = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(hotSpot).build().perform();

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        sa.assertEquals(alertText.contains("context"), true);
        alert.accept();
        sa.assertAll();






    }
}
