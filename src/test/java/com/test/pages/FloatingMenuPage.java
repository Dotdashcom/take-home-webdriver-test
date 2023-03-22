package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.util.Config;

public class FloatingMenuPage {

    private WebDriver driver;
    private By floatingMenu = By.id("menu");

    public FloatingMenuPage(WebDriver driver) {
        this.driver = driver;
        driver.get(Config.getUrl("floatingmenu"));
    }
    public By getFloatingMenuLocator() {
        return floatingMenu;
    }
    public float getFloatingMenuYOffset() {
        return (float) driver.findElement(floatingMenu).getLocation().getY();
    }
}
