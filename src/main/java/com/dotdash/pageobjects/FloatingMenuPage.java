package com.dotdash.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class FloatingMenuPage extends BasePage {

    @FindBy(how = How.CSS, using = "#menu > ul > li")
    private List<WebElement> floatingMenuButtons;

    public FloatingMenuPage(WebDriver driver) {
        super(driver);
    }

    public FloatingMenuPage goToFloatingMenuPage() {
        driver.get(BASEURL + "/floating_menu");
        return this;
    }

    public FloatingMenuPage scrollPageDown() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return this;
    }

    public List<WebElement> getFloatingMenuButtons() {
        return waitForVisibilityOf(floatingMenuButtons);
    }
}
