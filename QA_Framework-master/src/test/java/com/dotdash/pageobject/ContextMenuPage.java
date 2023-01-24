package com.dotdash.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.InputEvent;

public class ContextMenuPage extends BasePageObject{

    private final By right_click_area = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
        open_page("context_menu");
    }

    public ContextMenuPage right_click_on_target_area() {
        Actions action = new Actions(this.driver);
        WebElement context_element = this.driver.findElement(right_click_area);
        action.contextClick(context_element).perform();
        return this;
    }

    public ContextMenuPage is_alert_displayed() throws Exception{
        final String expected_alert_content = "You selected a context menu";
        String actual_alert_content = this.driver.switchTo().alert().getText();
        this.driver.switchTo().alert().accept();
        Assert.assertEquals(actual_alert_content, expected_alert_content, "[ERR] Wrong alert content");

        // Try to click to escape the context
        Robot robot = new Robot();
        robot.setAutoDelay(500);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        return this;
    }
}
