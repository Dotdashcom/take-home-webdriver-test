package Test;

import Utilities.DriverHelper;
import Main.CheckBoxesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxesTest {

    CheckBoxesPage checkboxes =new CheckBoxesPage();

    @Test
    public void checkBoxesCheck() throws InterruptedException {

        DriverHelper.getDriver().get("http://localhost:7080/checkboxes");

        Thread.sleep(3000);
        checkboxes.checkBox1.click();
        Assert.assertTrue(checkboxes.checkBox1.isSelected());

        Thread.sleep(3000);
        checkboxes.checkBox1.click();
        Assert.assertFalse(checkboxes.checkBox1.isSelected());

        DriverHelper.closeDriver();

    }

    @Test
    public void checkBoxesCheck2() throws InterruptedException {

        DriverHelper.getDriver().get("http://localhost:7080/checkboxes");

        DriverHelper.getDriver().manage().window().maximize();

        Thread.sleep(3000);
        checkboxes.checkBox2.click();
        Assert.assertFalse(checkboxes.checkBox2.isSelected());
        Thread.sleep(3000);

        checkboxes.checkBox2.click();
        Assert.assertTrue(checkboxes.checkBox2.isSelected());

        Thread.sleep(2);

        DriverHelper.closeDriver();


    }

}
