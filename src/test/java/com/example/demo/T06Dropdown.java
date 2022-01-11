package com.example.demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class T06Dropdown extends TestMain{
    DropdownPage dropdownPage;

    @Test
    public void testDropdown(){
        dropdownPage = new DropdownPage(driver);
        Assert.assertEquals(dropdownPage.selectOption("1"),"Option 1");
        Assert.assertEquals(dropdownPage.selectOption("2"),"Option 2");

    }
}
