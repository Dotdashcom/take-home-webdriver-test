package com.company.tests;

import com.company.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_DynamicContent extends TestBase {


    @Test
    public void dynamicContent(){

        driver.get("https://practice.cydeo.com/dynamic_content");

//        3. Verify “Simple dropdown” default selected value is correct
//        Expected: “Please select an option”
        Select simpleDropdown = new Select(driver.findElement(By.id("dropdown")));

        // getFirstSelectedOption() method will return to default selected option. Return type is webElement
        String actualDefaultSimpleDropdown = simpleDropdown.getFirstSelectedOption().getText();
        String expectedDefaultSimpleDropdown = "Please select an option";

        Assert.assertEquals(actualDefaultSimpleDropdown,expectedDefaultSimpleDropdown);

        // This line will not run because of hard assertion we used fail
        System.out.println("After hard assertion!");

    }
}




//  https://practice.cydeo.com/dynamic_content