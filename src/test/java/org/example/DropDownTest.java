package org.example;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownTest extends BasePage{

    protected DropDownPage dropDownPage;

    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        dropDownPage = PageFactory.initElements(driver, DropDownPage.class);
    }

    @Test
    public void option1Test(){

        dropDownPage.selectOption1();
        Assert.assertEquals(dropDownPage.getSelectedOption(),"Option 1");

    }

    @Test
    public void option2Test(){
        dropDownPage.selectOption2();
        Assert.assertEquals(dropDownPage.getSelectedOption(),"Option 2");
    }

    @AfterMethod
    public void endTest(){
        teardown();
    }

}
