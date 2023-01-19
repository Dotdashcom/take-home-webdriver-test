package Tests;

import Baseclass.BaseClass;
import Pages.Context_Menu_Page;
import Pages.Dropdown_Page;
import org.testng.annotations.Test;

public class Tests_Dropdown extends BaseClass {

    @Test
    public void T006_Dropdown_Testing() {
        String option_1 = "1";
        String option_2 = "2";
        Dropdown_Page dropdown_page = new Dropdown_Page(driver);
        dropdown_page.GoToDropDown();
        dropdown_page.SelectOption(option_1);
        dropdown_page.AssertOption("Option 1");
        dropdown_page.SelectOption(option_2);
        dropdown_page.AssertOption("Option 2");




    }

}
