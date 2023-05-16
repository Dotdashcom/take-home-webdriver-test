package homework.tests;

import homework.pages.DropdownPage;
import homework.test.TestBase;
import homework.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownStepDef extends TestBase {

    DropdownPage dropdownPage=new DropdownPage();

    @Test
    public void dropDownVerification(){
        Driver.getDriver().get("http://localhost:7080/dropdown");

        dropdownPage.dropDown.click();
        dropdownPage.option1.click();

        Assert.assertTrue(dropdownPage.option1.isSelected());

        dropdownPage.option2.click();

        Assert.assertTrue(dropdownPage.option2.isSelected());

    }
}
