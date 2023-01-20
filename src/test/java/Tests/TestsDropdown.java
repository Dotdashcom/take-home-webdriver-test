package Tests;

import Baseclass.BaseClass;
import Pages.DropdownPage;
import org.testng.annotations.Test;

public class TestsDropdown extends BaseClass {

    @Test
    public void T006_Dropdown_Testing() {
        String option_1 = "1";
        String option_2 = "2";
        DropdownPage dropdown_page = new DropdownPage(driver);
        dropdown_page.GoToDropDown();
        dropdown_page.SelectOption(option_1);
        dropdown_page.AssertOption("Option 1");
        dropdown_page.SelectOption(option_2);
        dropdown_page.AssertOption("Option 2");




    }

}
