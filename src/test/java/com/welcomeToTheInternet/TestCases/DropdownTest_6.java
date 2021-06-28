package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.DropdownPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class DropdownTest_6 extends BaseClass{

    @Test
    public void DropdownTest() {
        driver.get(baseURL);
        DropdownPage dropdown = new DropdownPage(driver);

        dropdown.clickDropdownLink();

        dropdown.clickDropDownList();
        dropdown.waitForList(driver);
        dropdown.selectElement1();

        dropdown.clickDropDownList();
        dropdown.waitForList(driver);
        dropdown.selectElement2();
    }
}
