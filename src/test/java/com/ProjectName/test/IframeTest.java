package com.ProjectName.test;

import com.ProjectName.Base.BaseTest;
import com.ProjectName.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest {

    @BeforeTest
    public void setupTest(){
        driver.get(BrowserUtils.getBaseUrl() + "/iframe");
    }

    @Test
    public void iframeTest(){

        WebElement frame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frame);
        WebElement textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("Wooden Spoon");
        Assert.assertEquals(textBox.getText(), "Wooden Spoon");

    }
}
