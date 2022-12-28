package com.test.localhost.tests;

import com.test.localhost.pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends TestBase {

    @Test
    public void dropDownPageTest(){
        DropdownPage dropdownPage=new DropdownPage(driver);
        dropdownPage.dropDownClick();
       dropdownPage.chooseOption1();
       Assert.assertEquals(dropdownPage.getTextOption(),"Option 1");
       dropdownPage.chooseOption2();
        Assert.assertEquals(dropdownPage.getTextOption(),"Option 2");

    }
}
