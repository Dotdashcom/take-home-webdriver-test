package com.dotdash;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTest extends Util {
	
	protected CheckBoxPage checkBoxPage;

    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        checkBoxPage = PageFactory.initElements(driver, CheckBoxPage.class);
    }

    @Test
    public void check_and_Uncheck_CheckBox1(){
        checkBoxPage.openPage();
        checkBoxPage.clickCheckbox("first");
        Assert.assertTrue(checkBoxPage.checkbox1().isSelected());
        checkBoxPage.clickCheckbox("first");
        Assert.assertFalse(checkBoxPage.checkbox1().isSelected());
    }

    @Test
    public void check_and_Uncheck_CheckBox2(){
        checkBoxPage.openPage();
        checkBoxPage.clickCheckbox("second");
        Assert.assertFalse(checkBoxPage.checkbox2().isSelected());
        checkBoxPage.clickCheckbox("second");
        Assert.assertTrue(checkBoxPage.checkbox2().isSelected());
    }

    @AfterMethod
    public void endTest(){
        teardown();
    }
}
