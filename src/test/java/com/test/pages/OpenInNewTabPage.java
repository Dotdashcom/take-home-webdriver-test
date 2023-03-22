package com.test.pages;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.util.Config;

public class OpenInNewTabPage {

    private WebDriver driver;

    private By hereLink = By.linkText("Click Here");

    public OpenInNewTabPage(WebDriver driver) {
        this.driver = driver;
        driver.get(Config.getUrl("newtab"));
    }

    public boolean isPageLoaded() {
        return driver.getTitle().equals("The Internet");
    }

    public void clickHereLink() {
        driver.findElement(hereLink).click();
    }

    public boolean isNewTabOpened() {
        String parentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        windows.remove(parentWindow);
        return windows.size() == 1;
    }

    public String getNewTabText() {
        String parentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        windows.remove(parentWindow);
        driver.switchTo().window(windows.iterator().next());
        String newTabText = driver.findElement(By.tagName("h3")).getText();
        driver.close();
        driver.switchTo().window(parentWindow);
        return newTabText;
    }
}
