package org.benjamin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewTab extends PageBase {
    private String originalWindows;

    public void init() {
        super.init("http://localhost:7080/windows");
    }

    public void destroy() {
        driver.close();
        driver.switchTo().window(originalWindows);
        driver.close();
    }

    public void openNewTab() {
        originalWindows = driver.getWindowHandle();
        WebElement btnNewTab = driver.findElement(By.cssSelector("a[href='/windows/new']"));
        btnNewTab.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.getWindowHandles().size() > 1);
    }

    public boolean checkNewTab() {
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(originalWindows)) {
                driver.switchTo().window(window);
                WebElement textBox = driver.findElement(By.cssSelector("h3"));
                return textBox.getText().equals("New Window");
            }
        }
        return false;
    }
}
