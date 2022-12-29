package com.company.tests;

import com.company.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 Test refreshes the page a couple of times.
 Test asserts that the content changes on each refresh.
 */

public class TestCase07DynamicContent {

    @Test
    public void dynamicContent() {

        Driver.getDriver().get("http://localhost:7080/dynamic_content");

        /* img changed after refresh page test */

        WebElement img1 = Driver.getDriver().findElement(By.xpath("//*[@id='content']/div[3]/div[1]/img"));
        String initialScreen = img1.getAttribute("src");

        Driver.getDriver().navigate().refresh();

        WebElement img2 = Driver.getDriver().findElement(By.xpath("//*[@id='content']/div[3]/div[1]/img"));
        String screenAfterRefresh = img2.getAttribute("src");

        Assert.assertNotEquals(initialScreen,screenAfterRefresh);


        /* text changed after refresh page test */

        WebElement text1 = Driver.getDriver().findElement(By.xpath("//*[@id='content']/div[3]/div[2]"));
        String initialText = text1.getText();

        Driver.getDriver().navigate().refresh();

        WebElement text2 = Driver.getDriver().findElement(By.xpath("//*[@id='content']/div[3]/div[2]"));
        String textAfterRefresh = text2.getText();

        Assert.assertNotEquals(initialText,textAfterRefresh);

        Driver.closeDriver();
    }
}


