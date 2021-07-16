package com.dotdash;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


/**
 * Scroll down concept.
 * TODO HW Scroll down to Featured Rentals.
 */
public class Test12FloatingMenu extends BaseMethod {

    @Test
    public void testScrollDownToElement1() {
        driver.get("http://localhost:7080/floating_menu ");
        By featuredFlightsLoc = By.xpath("//*[.='Featured Flights']");
        WebElement featuredFlightsElem = findByVisibility(featuredFlightsLoc);
        scrollToElement(featuredFlightsElem);
        Assert.assertEquals("Featured Flights", featuredFlightsElem.getText());
    }


    /**
     * <h1>scrollToElement</h1>
     * <p>Scroll down to the web element using Actions class.</p>
     * @param webElement to scroll down to
     */
    public void scrollToElement(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement);
        actions.perform();
    }


    /**
     * <h1>scrollToElement</h1>
     * <p>purpose: Scroll the screen such that the location of the WebElement is displayed in the view port.</p>
     * @param element = WebElement for pageObject
     */
    public void scrollToElement2(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(arguments[0],arguments[1])",
                element.getLocation().x, element.getLocation().y);
    }


    /**
     * <h1>scrollToElement</h1>
     * <p>purpose: Scroll the screen such that the location of the WebElement is displayed in the view port.</p>
     * @param locator = locator to create WebElement for pageObject
     */
    public void scrollToElement(By locator) {
        scrollToElement2(findByVisibility(locator));
    }








}