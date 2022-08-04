package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.ArrayList;

public class Test4ContextMenu extends GenericTest {

    @Test
    public void Test4ContextMenu() {
        String url = "http://localhost:7080/context_menu";
        String alertTextKey = "You selected a context menu";
        driver.get(url);

        //build action that performs a context click
        Actions contextClickAction = new Actions(driver);
        WebElement contextMenu = driver.findElement(By.xpath("//div[contains(@id,'hot-spot')]"));
        contextClickAction.contextClick(contextMenu).perform();

        //switch context to js alert and grab text
        Alert alert = driver.switchTo().alert();
        Boolean isAlertTextPresent = alert.getText().contains(alertTextKey);

        Assert.assertTrue(isAlertTextPresent);

        //get rid of alert and then get rid of the context menu
        alert.accept();

    }

}