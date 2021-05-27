package com.dotdash.stepDeffinition;

import com.dotdash.utillities.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownTest {

    @Before
    public void setup() {
        Driver.getDriver().get("http://localhost:7080/dropdown");

    }

    @After
    public void teardown() {

        Driver.closeDriver();
    }

    @Test
    public void dropdownTest1(){

        Select dropdown =new Select(Driver.getDriver().findElement(By.id("dropdown")));
        dropdown.selectByVisibleText("Option 1");

        String expectedOption = "Option 1";
        String actualOption = dropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedOption,actualOption);


    }


    @Test
    public void dropdownTest2(){

        Select dropdown =new Select(Driver.getDriver().findElement(By.id("dropdown")));
        dropdown.selectByVisibleText("Option 2");

        String expectedOption = "Option 2";
        String actualOption = dropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedOption,actualOption);


    }



}
