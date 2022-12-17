package Tests;

import Pages.BasePage;
import Pages.DropDownPage;
import Utils.Driver;
import Utils.HelpfulMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDownVerification extends BasePage {
    DropDownPage dropDownPage = new DropDownPage();

    @BeforeClass
    public void SetUp() {
        Driver.GetDriver().get("http://localhost:7080/dropdown");
    }

    @Test
    public void TCCheckBoxVerification() {
        dropDownPage.selectFromDropDown("Option 1");
        Assert.assertEquals(dropDownPage.selectVerification("Option 1"),"Option 1","Option 1 is not selected");
        HelpfulMethods.staticWait(5);
        dropDownPage.selectFromDropDown("Option 2");
        Assert.assertEquals(dropDownPage.selectVerification("Option 2"),"Option 2","Option 2 is not selected");

    }

}
