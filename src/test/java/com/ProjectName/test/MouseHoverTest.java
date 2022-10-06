package com.ProjectName.test;

import com.ProjectName.Base.BaseTest;
import com.ProjectName.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseHoverTest extends BaseTest {

    @BeforeTest
    public void setupTest(){
        driver.get(BrowserUtils.getBaseUrl() + "/hovers");
    }

    @Test
    public void hoverTest(){

        WebElement avatar1 = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
        WebElement avatar2 = driver.findElement(By.xpath("(//div[@class='figure'])[2]"));
        WebElement avatar3 = driver.findElement(By.xpath("(//div[@class='figure'])[3]"));

        WebElement displayedName1 = driver.findElement(By.xpath("(//h5)[1]"));
        WebElement displayedName2 = driver.findElement(By.xpath("(//h5)[2]"));
        WebElement displayedName3 = driver.findElement(By.xpath("(//h5)[3]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(avatar1).build().perform();
        Assert.assertTrue(displayedName1.isDisplayed());
        Assert.assertFalse(displayedName2.isDisplayed());
        Assert.assertFalse(displayedName3.isDisplayed());

        actions.moveToElement(avatar2).build().perform();
        Assert.assertTrue(displayedName2.isDisplayed());
        Assert.assertFalse(displayedName1.isDisplayed());
        Assert.assertFalse(displayedName3.isDisplayed());

        actions.moveToElement(avatar3).build().perform();
        Assert.assertTrue(displayedName3.isDisplayed());
        Assert.assertFalse(displayedName1.isDisplayed());
        Assert.assertFalse(displayedName2.isDisplayed());

    }
}
