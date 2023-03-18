package com.hired.tests;

import com.dotdash.pages.BasePage;
import com.dotdash.pages.CheckBoxPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTest extends BasePage {
    public WebDriver driver;
    CheckBoxPage checkBoxPage;
    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        driver.get(prop.getProperty("checkboxesUrl"));
    }

    @Test
    public void validateCheckboxes(){

        checkBoxPage= new CheckBoxPage(driver);
        Assert.assertTrue( !checkBoxPage.checkBox1.isSelected());
        Assert.assertTrue(checkBoxPage.checkBox2.isSelected());
        checkBoxPage.checkBox1.click();
        checkBoxPage.checkBox2.click();
        Assert.assertTrue( checkBoxPage.checkBox1.isSelected());
        Assert.assertTrue(!checkBoxPage.checkBox2.isSelected());
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
