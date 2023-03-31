package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBox;

public class CheckBoxTest extends TestBase {
    @Test
    public void test() {
        driver.get("http://localhost:7080/checkboxes ");
        CheckBox checkBoxTest = new CheckBox(driver);
        checkBoxTest.clickCheckBox1(driver);
        Assert.assertTrue(checkBoxTest.isSelected1());
        checkBoxTest.clickCheckBox2(driver);
        Assert.assertTrue(!checkBoxTest.isSelected2());
        checkBoxTest.clickCheckBox1(driver);
        Assert.assertTrue(!checkBoxTest.isSelected1());

    }

}
