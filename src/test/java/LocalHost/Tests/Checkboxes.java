package LocalHost.Tests;

import LocalHost.Pages.CheckBoxesPage;
import LocalHost.Utilities.BrowserUtils;

import org.testng.annotations.Test;

public class Checkboxes extends TestingBase {

    @Test(groups = {"Checkbox"})
    public void CheckBox_Test() {
        BrowserUtils.waitForPageToLoad(5);
        CheckBoxesPage checkbox = new CheckBoxesPage();

        checkbox.Select_Checkbox1();
        BrowserUtils.waitFor(3);
        checkbox.Unselect_Checkbox2();
        BrowserUtils.waitFor(3);


    }

}
