package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.Constants;

import java.util.Set;

public class NewTab extends Constants {

    @Test
    public void newTab() {
        driver.get("http://localhost:7080/windows");

        driver.findElement(By.linkText("Click Here")).click();

        String parentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();

        for (String window: windows) {
            if (window.equals(parentWindow)) continue;
            driver.switchTo().window(window);
        }

        String message = driver.findElement(By.tagName("h3")).getText().trim();
        sa.assertEquals(message, "New Window");
        sa.assertAll();
    }
}
