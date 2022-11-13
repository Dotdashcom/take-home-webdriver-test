package com.dotdashcom.pagemodels;

import com.dotdashcom.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FloatingMenuPageModel extends PageObject {

    public static final String PAGE_URL = "/floating_menu";

    @FindBy(id = "menu")
    private WebElement menu;

    public FloatingMenuPageModel(WebDriver driver) {
        super(driver);
    }

    public WebElement getMenu() {
        return menu;
    }

    public List<WebElement> findMenuItems() {
        return getMenu().findElements(By.tagName("li"));
    }

    public void scrollBrowserWindow() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
