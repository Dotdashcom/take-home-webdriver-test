package org.example;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTest extends BasePage{

    protected CheckBoxPage checkBoxPage;

    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        checkBoxPage = PageFactory.initElements(driver, CheckBoxPage.class);
    }

    @Test
    public void check_and_Uncheck_CheckBox1(){
        checkBoxPage.navigateCheckBoxPage();
        checkBoxPage.clickCheckbox1();
        Assert.assertTrue(checkBoxPage.getcheckbox1().isSelected());
        checkBoxPage.clickCheckbox1();
        Assert.assertFalse(checkBoxPage.getcheckbox1().isSelected());
    }

    @Test
    public void check_and_Uncheck_CheckBox2(){
        checkBoxPage.navigateCheckBoxPage();
        checkBoxPage.clickCheckbox2();
        Assert.assertFalse(checkBoxPage.getcheckbox2().isSelected());
        checkBoxPage.clickCheckbox2();
        Assert.assertTrue(checkBoxPage.getcheckbox2().isSelected());
    }

    @AfterMethod
    public void endTest(){
        teardown();
    }

}
