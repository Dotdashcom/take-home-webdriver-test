package com.web.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.TestBase;
import com.web.pages.CheckBoxesPage;

public class CheckBoxesTest extends TestBase{

    CheckBoxesPage checkboxespage;
    public CheckBoxesTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        driver.get("http://localhost:7080/checkboxes");
        checkboxespage = new CheckBoxesPage();
    }


    @Test()
    public void verifyCheckboxIsChecked()
    {
        checkboxespage.checkboxSelected();
        Assert.assertTrue(checkboxespage.checkBox1Selected());
        Assert.assertFalse(checkboxespage.checkBox2Selected());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
