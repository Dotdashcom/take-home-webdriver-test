package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MouseHoverPage extends BasePage {

    // PAGE INITIALIZATION:
    public MouseHoverPage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By USERS = By.cssSelector("div[class='figure']");

    // WEB ELEMENTS:
    private List<WebElement> getUsers() {
        wait.until(ExpectedConditions.elementToBeClickable(USERS));
        return driver.findElements(USERS);
    }

    // METHODS:
    public boolean areFiguresDisplayed() {
        List<WebElement> listOfFigures = getUsers();
        Actions actions = new Actions(driver);
        boolean isDisplayed = true;

        for (WebElement figures : listOfFigures) {
            log.warn("User makes mouse hover. ");
            actions.moveToElement(figures).perform();
            System.out.println(" =====> " + figures.getText() + " <===== ");

            for (WebElement figuresTxt : listOfFigures)
                if (figuresTxt.isDisplayed() && isDisplayed) {
                    isDisplayed = figuresTxt.isDisplayed();
                }
        }
        log.warn("User can see figures texts. ");
        return isDisplayed;
    }
}



