package com.dotdash.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FloatingMenuPage extends BasePage {
    @FindBy(id="menu")
    WebElement floatingMenu;

    public FloatingMenuPage(WebDriver driver) {
        super(driver);
    }

    public void scrollDown(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.scrollBy(0,500)");
    }

    public boolean isMenuDisplayed(){
        return floatingMenu.isDisplayed();
    }
}
