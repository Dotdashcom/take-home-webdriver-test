package com.example.cucumber.page.mouseHover;

import com.example.navigation.WebDriverJavaUtil;
import com.example.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.example.constants.Page.MOUSE_HOVER_PAGE;
import static com.example.constants.PageLinkText.HOVERS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MouseHoverPage extends WebDriverJavaUtil {
    WebDriver driver;
    ReadProperties readProperties = new ReadProperties();
    public MouseHoverPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By mouse_hover_page_link = By.linkText(HOVERS);
    public void the_user_clicks_on_the_mouse_hover_page() {
        clckOnWebElement(mouse_hover_page_link);
    }

    public void the_user_should_see_the_mouse_hover_page() {
        assertEquals("Mouse Hover Page URL doesn't Match: ", MOUSE_HOVER_PAGE, driver.getCurrentUrl());
    }

    public void the_user_hover_mouse_on_the_mouse_hover_page() {
        Actions action = new Actions(driver);
        List<WebElement> images = driver.findElements(By.className("figure"));
        images.forEach(img -> {
            action.moveToElement(img).perform();
            waitForMilliSeconds(1000);
            assertTrue("Hover Text Not Displayed: ", img.findElement(By.className("figcaption")).isDisplayed());
             });
    }

    public void theUserShouldSeeTheHoverTextOnTheMouseHoverPage(String mouseHoverText) {
        Actions action = new Actions(driver);
        List<WebElement> images = driver.findElements(By.className("figure"));
        images.forEach(img -> {
            action.moveToElement(img).perform();
            waitForMilliSeconds(1000);
            assertEquals("Hover Text Not Correct: ", true, img.findElement(By.className("figcaption")).getText().contains(mouseHoverText));
        });
    }
}
