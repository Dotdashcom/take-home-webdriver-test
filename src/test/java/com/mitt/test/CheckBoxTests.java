package com.mitt.test;

import com.mitt.pages.CheckBoxesPage;
import com.mitt.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckBoxTests extends BaseTest{
    CheckBoxesPage checkBoxesPage;

    @BeforeClass
    public void setUp(){
        checkBoxesPage = new CheckBoxesPage(getDriver(), getWait());
    }

    @Test(dataProvider = "checkboxData")
    public void selectOneCheckBoxTest(String checkboxName) throws Exception {

        checkBoxesPage.click_one_checkBox(checkboxName);

        Assert.assertEquals(true,  checkBoxesPage.isSelected(checkboxName));
    }

    @Test
    public void selectBothCheckBoxTest() throws Exception {

        checkBoxesPage.click_both_checkBox();

        Assert.assertEquals(true,  checkBoxesPage.isSelected("checkbox1"));
        Assert.assertEquals(true,  checkBoxesPage.isSelected("checkbox2"));
    }

    @Test(dataProvider = "checkboxData")
    public void uncheckBoxTest(String checkboxName) throws Exception {

        checkBoxesPage.uncheckBox(checkboxName);

        Assert.assertEquals(false,  checkBoxesPage.isSelected("checkbox1"));
        Assert.assertEquals(false,  checkBoxesPage.isSelected("checkbox2"));
    }

    @DataProvider(name = "checkboxData")
    public Object[][] valid_login_credential() {
        return new Object [][] {
                {"checkbox1"},
                {"checkbox2"}
        } ;
    }
}
