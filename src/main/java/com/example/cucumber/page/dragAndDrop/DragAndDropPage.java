package com.example.cucumber.page.dragAndDrop;

import com.example.navigation.WebDriverJavaUtil;
import com.example.utils.ReadProperties;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static com.example.constants.Page.DRAG_AND_DROP_PAGE;
import static com.example.constants.PageLinkText.DRAG_AND_DROP;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DragAndDropPage extends WebDriverJavaUtil {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By drag_And_Drop_Page_Link = By.linkText(DRAG_AND_DROP);
    private Point initialPositionSourceElement;

    WebDriver driver;
    ReadProperties readProperties = new ReadProperties();

    public void the_user_clicks_on_drag_and_drop_page() {
        clckOnWebElement(drag_And_Drop_Page_Link);
    }

    public void the_user_should_see_the_drag_and_drop_page() {
        assertEquals("Drag And Drop Page URL doesn't Match: ", DRAG_AND_DROP_PAGE, driver.getCurrentUrl());
    }

    public void the_user_drag_draggable_item_into_the_item_on_the_drag_and_drop_page(String startPosition, String endPosition) {
        String sourceXpath = "//*[@draggable='true']/header/text()[normalize-space()='" + startPosition + "']//ancestor::div[@draggable]";
        WebElement sourceElement = driver.findElement(By.xpath(sourceXpath));
        initialPositionSourceElement = sourceElement.getLocation();
        String targetXpath = "//*[@draggable='true']/header/text()[normalize-space()='" + endPosition + "']//ancestor::div[@draggable]";
        WebElement targetElement = driver.findElement(By.xpath(targetXpath));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, targetElement).build().perform();
        waitForMilliSeconds(1000);
    }

    public void the_user_should_see_the_item_into_the_item_on_the_drag_and_drop_page(String startPosition, String endPosition) {
        String sourceXpath = "//*[@draggable='true']/header/text()[normalize-space()='" + startPosition + "']//ancestor::div[@draggable]";
        WebElement sourceElement = driver.findElement(By.xpath(sourceXpath));
        Point finalPositionSourceElement = sourceElement.getLocation();
        assertNotEquals("Drag and Drop not successful: ", initialPositionSourceElement, finalPositionSourceElement);
        }
}
