package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Test4ContextMenu extends chromedriver {

    @Test
    public void Test4ContextMenu() {
        String url = "http://localhost:7080/context_menu";
        String alertTextKey = "You selected a context menu";
        driver.get(url);
        Actions contextClickAction = new Actions(driver);
        WebElement contextMenu = driver.findElement(By.xpath("//div[contains(@id,'hot-spot')]"));
        contextClickAction.contextClick(contextMenu).perform();
        Alert alert = driver.switchTo().alert();
        boolean isAlertTextPresent = alert.getText().contains(alertTextKey);
        Assert.assertTrue(isAlertTextPresent);
        alert.accept();

    }

}