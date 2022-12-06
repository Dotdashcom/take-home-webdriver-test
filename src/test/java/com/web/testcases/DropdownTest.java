package com.web.testcases;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.TestBase;
import com.web.pages.DropdownPage;

public class DropdownTest extends TestBase{
    DropdownPage dropdownPage;

    public DropdownTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        driver.get("http://localhost:7080/dropdown");
        dropdownPage = new DropdownPage();
    }


    @Test()
    public void verifyDropdown(){
        dropdownPage.dropdownMenu().click();

        Select dropdown = new Select(dropdownPage.dropdownMenu());

        dropdown.selectByVisibleText("Option 1");
        Assert.assertEquals(dropdownPage.getOption1(),"Option 1");

        dropdownPage.dropdownMenu().click();

        dropdown.selectByVisibleText("Option 2");
        Assert.assertEquals(dropdownPage.getOption2(),"Option 2");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
