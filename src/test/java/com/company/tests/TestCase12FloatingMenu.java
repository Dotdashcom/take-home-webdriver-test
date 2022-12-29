package com.company.tests;

import com.company.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test scrolls the page.
 * Test asserts that the floating menu is still displayed.
 */

public class TestCase12FloatingMenu {

    @Test
    public void floatingMenu() {

        Driver.getDriver().get("http://localhost:7080/floating_menu");

        JavascriptExecutor je = (JavascriptExecutor) Driver.getDriver();

        WebElement floatingMenuHome = Driver.getDriver().findElement(By.xpath("//*[@id='menu']/ul/li[1]/a"));

        je.executeScript("arguments[0].scrollIntoView(true);",floatingMenuHome);

        Assert.assertEquals(floatingMenuHome.getText(),"Home","Result Home menu verification failed!");

        Driver.closeDriver();
    }
}
