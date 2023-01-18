package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FloatingMenuPage extends BasePage {

    // PAGE INITIALIZATION:
    public FloatingMenuPage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By MENU = By.cssSelector("#menu ul li");

    // WEB ELEMENTS:
    private List<WebElement> getFloatingMenu() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MENU));
        return driver.findElements(MENU);
    }


    // METHODS:
    public void scrollDownPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        log.info("User scrolls page down. ");
        js.executeScript("window.scrollBy(0,4730)");
    }

    public void scrollUpPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        log.info("User scrolls page up. ");
        js.executeScript("window.scrollBy(0,-4730)");
    }

    public boolean isFloatingMenuDisplayed() {
        List<WebElement> menuList = getFloatingMenu();
        boolean flag = true;
        for (WebElement element : menuList) {
            if (element.isDisplayed() && flag) {
                flag = element.isDisplayed();
            }
        }
        log.info("Floating menu is displayed. ");
        return flag;
    }
}


