package com.academy.techcenture;

import com.academy.techcenture.pages.DropdownPage;
import org.testng.annotations.Test;

public class DropDownTest extends BaseClassTest {

    @Test
    public void dropDownTest(){
        DropdownPage dropdownPage = new DropdownPage(driver, softAssert);
        dropdownPage.navigateTo("/dropdown");
        dropdownPage.verifyDropDown();
    }
}
