package com.dashDot;

import org.openqa.selenium.By;

public class Window_Handling extends Main{
    public void win_handling() throws InterruptedException {
        driver.get("http://localhost:7080/windows ");
        String parent = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();
        String newWin = driver.getWindowHandle();
        Thread.sleep(1000);
        driver.switchTo().window(parent);

    }
}
