package LocalHost.Tests;

import LocalHost.Pages.DropDownPage;
import static LocalHost.Utilities.BrowserUtils.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDown extends TestingBase {

    @Test(groups = {"DropDown"})
    public void SelectOption1(){
        DropDownPage drop = new DropDownPage();
        waitForPageToLoad(3);
        drop.SelectOption1();
        Assert.assertTrue(drop.Verify_Selection("Option 1"));
        waitFor(3);
    }
    @Test(groups = {"DropDown"})
    public void SelectOption2(){
        DropDownPage drop = new DropDownPage();
        waitForPageToLoad(3);
        drop.SelectOption2();
        Assert.assertTrue(drop.Verify_Selection("Option 2"));
        waitFor(3);
    }
    @Test(groups = {"DropDown"})
    public void SelectChosenOption(){
        int x=2;
        DropDownPage drop = new DropDownPage();
        waitForPageToLoad(3);
        drop.Select_By_Option_Number(x);
        Assert.assertTrue(drop.Verify_Selection("Option "+x));
        waitFor(3);
    }
}
