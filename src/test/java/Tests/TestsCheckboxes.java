package Tests;

import Baseclass.BaseClass;
import Pages.CheckboxPage;
import org.testng.annotations.Test;

public class TestsCheckboxes extends BaseClass {

    @Test
    public void T003_Checkboxes_Testing() {
        CheckboxPage checkbox_page = new CheckboxPage(driver);
        checkbox_page.GoToCheckboxPage();
        checkbox_page.Clicking_Successful();
        checkbox_page.AssertState();


    }

}
