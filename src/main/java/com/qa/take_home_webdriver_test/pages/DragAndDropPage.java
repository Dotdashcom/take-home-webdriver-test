package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DragAndDropPage extends BasePage {

    // PAGE INITIALIZATION:
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By BOX_A = By.id("column-a");
    private static final By BOX_B = By.id("column-b");

    // WEB ELEMENTS:
    private WebElement getBox_A() {
        wait.until(ExpectedConditions.elementToBeClickable(BOX_A));
        return driver.findElement(BOX_A);
    }

    private WebElement getBox_B() {
        wait.until(ExpectedConditions.elementToBeClickable(BOX_B));
        return driver.findElement(BOX_B);
    }

    // METHODS:
    public void doDragAndDrop() {
        Actions actions = new Actions(driver);
        log.info("User takes a 'Box B' and drops on the 'Box A'. ");
        actions.dragAndDrop(getBox_A(), getBox_B()).build().perform();
    }

    public boolean validateDragAndDrop(String boxA_Txt, String boxB_Txt1) {
        log.warn("The 'Box A' and 'Box B' are displayed. ");
        while (getBox_A().isDisplayed() && getBox_A().isDisplayed()) {
            if (getBox_A().getText().equals(boxB_Txt1) && getBox_B().getText().equals(boxA_Txt)) {
                log.info("The texts of the boxes have been switched. ");
                return true;
            }
        }
        return false;
    }
}


