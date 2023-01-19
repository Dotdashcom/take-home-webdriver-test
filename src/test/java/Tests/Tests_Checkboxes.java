package Tests;

import Baseclass.BaseClass;
import Pages.Checkbox_Page;
import org.testng.annotations.Test;

public class Tests_Checkboxes extends BaseClass {

    @Test
    public void T003_Checkboxes_Testing() {
        Checkbox_Page checkbox_page = new Checkbox_Page(driver);
        checkbox_page.GoToCheckboxPage();
        checkbox_page.Clicking_Successful();
        checkbox_page.AssertState();


    }

}
