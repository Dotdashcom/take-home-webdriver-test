package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.test.util.Config;

import java.util.List;

public class MouseHoverPage {

    private WebDriver driver;
    private By imageContainers = By.cssSelector(".figure");
    private By imageCaptions = By.cssSelector(".figcaption h5");

    public MouseHoverPage(WebDriver driver) {
        this.driver = driver;
        driver.get(Config.getUrl("mousehover"));
    }

    public void hoverOverImages() {
        List<WebElement> images = driver.findElements(imageContainers);
        Actions actions = new Actions(driver);
        for (WebElement image : images) {
            actions.moveToElement(image).perform();
        }
    }

    public boolean areImageCaptionsDisplayed() {
        List<WebElement> captions = driver.findElements(imageCaptions);
        for (WebElement caption : captions) {
            if (!caption.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
}
