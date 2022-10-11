package com.ProjectName.test;

import com.ProjectName.Base.BaseTest;
import com.ProjectName.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {

    @BeforeTest
    public void setupTest(){
        driver.get(BrowserUtils.getBaseUrl() + "/dropdown");
    }

    @Test
    public void dropdownTest(){

        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownElement);
        System.out.println(select.getOptions());
        select.selectByVisibleText("Option 1");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
        select.selectByVisibleText("Option 2");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");

    }
}
