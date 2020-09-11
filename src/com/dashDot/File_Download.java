package com.dashDot;

import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;

public class File_Download extends Main{
    public void file_download() throws AWTException {
        driver.get(" http://localhost:7080/download");
        driver.findElement(By.linkText("some-file.txt"));
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }
}
