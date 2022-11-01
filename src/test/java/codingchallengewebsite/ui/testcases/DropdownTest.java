package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITest;
import codingchallengewebsite.ui.pageobjects.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class DropdownTest extends UITest {

    public DropdownTest() { }

    @Test(description="Dropdown options can be selected")
    public void selectAllOptions() {
        DropdownPage dropdownPage = new DropdownPage(this);
        List<String> options = dropdownPage.getDropdownOptions();

        // Validate page loaded
        Assert.assertTrue(dropdownPage.isPageOpen(), "Page not open");

        // Validate selectable options
        for (String option : options) {
            dropdownPage.setDropdownOption(option);
            Assert.assertTrue(dropdownPage.isDropdownOptionSelected(option), "Dropdown option not selected");
        }
    }
}