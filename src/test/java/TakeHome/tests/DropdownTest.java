package TakeHome.tests;

import TakeHome.pages.DropdownPage;
import TakeHome.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DropdownTest extends TestBase{
    List<String>expectedDropdownOptions = new ArrayList<>(Arrays.asList("Option 1", "Option 2"));

    @Test(groups = {"DropDown"})
    public void selectOption1Test(){
        DropdownPage drop = new DropdownPage();
        BrowserUtils.waitForPageToLoad(3);
        drop.selectOption1();
        Assert.assertEquals(drop.getSelectedOptionText(), "Option 1", "The selected dropdown option should be 'Option 1' but is not");
        BrowserUtils.waitFor(3);
    }
    @Test(groups = {"DropDown"})
    public void SelectOption2(){
        DropdownPage drop = new DropdownPage();
        BrowserUtils.waitForPageToLoad(3);
        drop.selectOption2();
        Assert.assertEquals(drop.getSelectedOptionText(), "Option 2", "The selected dropdown option should be 'Option 2' but is not");
        BrowserUtils.waitFor(3);
    }
}
