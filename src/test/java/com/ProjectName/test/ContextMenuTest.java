package com.ProjectName.test;

import com.ProjectName.Base.BaseTest;
import com.ProjectName.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    @BeforeTest
    public void setupTest(){
        driver.get(BrowserUtils.getBaseUrl() + "/context_menu");
    }

    @Test
    public void contextMenuTest(){

        WebElement rightClickArea = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickArea).perform();
        String expectedAlert = driver.switchTo().alert().getText();
        String actualAlert = "You selected a context menu";
        Assert.assertEquals(actualAlert, expectedAlert, "Alert text don't match");
        driver.switchTo().alert().accept();

    }
}
