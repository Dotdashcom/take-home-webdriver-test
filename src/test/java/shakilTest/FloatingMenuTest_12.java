package shakilTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FloatingMenuTest_12 extends TestBase {

    @Test
    public void testFloatingMenu() {
        driver.get("http://localhost:7080/floating_menu");

        // Verify that all the menu items are visible
        List<WebElement> menuItems = driver.findElements(By.xpath("//div[@id='menu']/ul//a"));
        Assert.assertEquals(menuItems.size(), 4, "Not all menu items are visible");

        // Scroll down the page
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Verify that the floating menu is still displayed
        for (WebElement menuItem : menuItems) {
            Assert.assertTrue(menuItem.isDisplayed(), "The floating menu is not displayed");
        }
    }
}


/*
 
 
 
xpath for Home menu //div[@id='menu']/ul//a[@href='#home']
xpath for news menu //div[@id='menu']/ul//a[@href='#news']
xpath for contact menu //div[@id='menu']/ul//a[@href='#contact']
xpath for about menu //div[@id='menu']/ul//a[@href='#about']
 
 
 */