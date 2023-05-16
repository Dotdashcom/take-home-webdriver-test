package homework.tests;

import homework.pages.CheckBoxPage;
import homework.test.TestBase;
import homework.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxStepDef extends TestBase {

    CheckBoxPage checkBoxPage=new CheckBoxPage();


    @Test
    public void testCheckBox1() {

        Driver.getDriver().get("http://localhost:7080/checkboxes");
        checkBoxPage.checkBox1.click();
        Assert.assertTrue(checkBoxPage.checkBox1.isSelected());


        checkBoxPage.checkBox1.click();
        Assert.assertFalse(checkBoxPage.checkBox1.isSelected());


    }

    @Test
    public void testCheckBox2(){

        Driver.getDriver().get("http://localhost:7080/checkboxes");
        checkBoxPage.checkBox2.click();
        Assert.assertTrue(checkBoxPage.checkBox2.isSelected());


        checkBoxPage.checkBox2.click();
        Assert.assertFalse(checkBoxPage.checkBox2.isSelected());


    }

}
