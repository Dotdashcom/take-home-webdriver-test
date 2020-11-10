package Tests;

import PageRepositories.DropdownList;
import Utils.UITestListeners;
import io.qameta.allure.*;
import org.testng.annotations.*;


@Listeners({ UITestListeners.class })
public class DropdownListTest extends BaseTest {
    @Test(priority=1)
    @Description("Select Option 1 in Dropdown List Page")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Dropdown List")
    public void select_dropdown_option1() {
        DropdownList dropdownList = new DropdownList(driver);

        dropdownList.navigate_to_dropdown_list_page(base_url);
        dropdownList.validate_dropdown_page_header();
        dropdownList.select_option1();
        dropdownList.verify_option1_selected();
    }

    @Test(priority=1, enabled = true, invocationCount = 1)
    @Description("Select Option 2 in Dropdown List Page")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Dropdown List")
    public void select_dropdown_option2() {
        DropdownList dropdownList = new DropdownList(driver);

        dropdownList.navigate_to_dropdown_list_page(base_url);
        dropdownList.validate_dropdown_page_header();
        dropdownList.select_option2();
        dropdownList.verify_option2_selected();
    }
}