package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITests;
import codingchallengewebsite.ui.pageobjects.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTest extends UITests {

    public DropdownTest() {
    }

    @Test(description="Dropdown options can be selected")
    public void selectAllOptions() {
        DropdownPage dropdownPage = new DropdownPage(this.driver, this);
        Assert.assertTrue(dropdownPage.isPageOpen(), "Page not open");
        List<String> options = dropdownPage.getDropdownOptions();

        for (String option : options) {
            dropdownPage.setDropdownOption(option);
            Assert.assertTrue(dropdownPage.isDropdownOptionSelected(option), "Dropdown option not selected");
        }
    }
}
