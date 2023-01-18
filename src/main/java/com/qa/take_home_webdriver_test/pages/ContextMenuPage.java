package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContextMenuPage extends BasePage {

    // PAGE INITIALIZATION:
    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By HOTSPOT = By.id("hot-spot");

    // WEB ELEMENTS:
    private WebElement getHotSpot() {
        wait.until(ExpectedConditions.elementToBeClickable(HOTSPOT));
        return driver.findElement(HOTSPOT);
    }

    // METHODS:
    public void performRightClick() {
        Actions action = new Actions(driver);
        log.info("User performs right click on the hot spot. ");
        action.contextClick(getHotSpot()).perform();
        log.warn("An alert message is raised up. ");
    }

    public String handleJSAlert() {
        Alert alert = driver.switchTo().alert();
        String alertTxt = alert.getText();
        System.out.println(" =====> Alert message is" + " '" + alertTxt + "' " + " <===== ");
        log.info("User accepts the alert message. ");
        alert.accept();

        return alertTxt;
    }

}


