package Tests;

import PageRepositories.CheckBoxes;
import Utils.UITestListeners;
import Utils.Utils;
import io.qameta.allure.*;
import org.testng.annotations.*;


@Listeners({ UITestListeners.class })
public class CheckBoxesTest extends BaseTest {
    @Test(priority=1)
    @Description("Select Checkbox 1 in Checkboxes Page")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Checkboxes")
    public void select_checkbox1() {
        CheckBoxes checkBoxes = new CheckBoxes(driver);

        checkBoxes.navigate_to_checkboxes_page(base_url);
        checkBoxes.validate_checkboxes_page_header();
        checkBoxes.select_checkbox("checkbox 1");
    }

    @Test(priority=1, enabled = true, invocationCount = 1)
    @Description("Select Checkbox 2 in Checkboxes Page")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Checkboxes")
    public void select_checkbox2() {
        CheckBoxes checkBoxes = new CheckBoxes(driver);

        checkBoxes.navigate_to_checkboxes_page(base_url);
        checkBoxes.validate_checkboxes_page_header();
        checkBoxes.select_checkbox("checkbox 2");
    }

    @Test(priority=1, enabled = true, invocationCount = 1)
    @Description("Select Checkbox 1 and Unselect Checkbox 2 in Checkboxes Page")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Checkboxes")
    public void select_checkbox1_and_unselect_checkbox2() {
        CheckBoxes checkBoxes = new CheckBoxes(driver);

        checkBoxes.navigate_to_checkboxes_page(base_url);
        checkBoxes.validate_checkboxes_page_header();
        checkBoxes.select_checkbox("checkbox 1");
        checkBoxes.unselect_checkbox("checkbox 2");
    }

    @Test(priority=1, enabled = true, invocationCount = 1)
    @Description("Unselect Checkbox 1 and Select Checkbox 2 in Checkboxes Page")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Checkboxes")
    public void unselect_checkbox1_and_select_checkbox2() {
        Utils utils = new Utils();
        CheckBoxes checkBoxes = new CheckBoxes(driver);

        checkBoxes.navigate_to_checkboxes_page(base_url);
        checkBoxes.validate_checkboxes_page_header();
        checkBoxes.unselect_checkbox("checkbox 1");
        checkBoxes.select_checkbox("checkbox 2");

    }
}