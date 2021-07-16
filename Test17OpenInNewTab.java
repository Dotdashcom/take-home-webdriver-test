package com.dotdash;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Set;

public class Test17OpenInNewTab extends BaseMethod {
    @Test
    public void testMultipleWindows1() {
        driver.get("http://localhost:7080/windows");
        By clickHereLoc = By.cssSelector(".example a");
        findByClickability(clickHereLoc).click();

        Object[] allWindows = driver.getWindowHandles().toArray();
        System.out.println(Arrays.toString(allWindows)); //sample result [CDwindow-F349027178DD834A7B4FCAEF2674B467, CDwindow-3A5386AB452B0DD05BD685EAFF8812E6]

        driver.switchTo().window(allWindows[1].toString());
        Assert.assertEquals("New Window", driver.getTitle());

        driver.switchTo().window(allWindows[0].toString());
        Assert.assertNotEquals("New Window", driver.getTitle());
    }

    /**
     * Use this approach if there are multiple window titles.
     */
    @Test
    public void testMultipleWindows2() {
        driver.get("http://localhost:7080/windows");
        String firstWindow = driver.getWindowHandle();
        System.out.println(firstWindow);
        String newWindow = "";

        driver.findElement(By.cssSelector(".example a")).click();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(firstWindow)) {
                newWindow = window;
            }
        }

        driver.switchTo().window(newWindow);
        Assert.assertEquals("New Window", driver.getTitle());

        driver.switchTo().window(firstWindow);
        Assert.assertNotEquals("New Window", driver.getTitle());
    }
}
