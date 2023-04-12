package org.benjamin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class FloatingMenu extends PageBase{

    public void init() {
        super.init("http://localhost:7080/floating_menu#home");
    }

    public void scroll() {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0 ,500);
    }

    public boolean isFloatingMenuDisplayed() {
        return driver.findElement(By.id("menu")).isDisplayed();
    }
}
