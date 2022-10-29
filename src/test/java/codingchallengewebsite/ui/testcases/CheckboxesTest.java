package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITest;
import codingchallengewebsite.ui.pageobjects.CheckboxesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

public class CheckboxesTest extends UITest {
    private int index;
    public CheckboxesTest() { }
    @Test(description="Checkboxes can be checked and unchecked")
    public void checkboxChecking() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(this);

        // Validate page loaded
        Assert.assertTrue(checkboxesPage.isPageOpen(), "Page not open");

        // All checkboxes toggled back and forth
        IntStream.range(0, checkboxesPage.getCheckboxElements().size()).forEach(index-> {
            Boolean prevStatus, currentStatus, expectedStatus;
            // Toggle/untoggle the checkbox
            prevStatus = checkboxesPage.clickOnCheckbox(index);
            currentStatus = checkboxesPage.getCheckboxCurrentValue(index);
            Assert.assertNotEquals(prevStatus, currentStatus);
            // Toggle/untoggle the checkbox back
            expectedStatus = checkboxesPage.getCheckboxExpectedValue(index);
            checkboxesPage.clickOnCheckbox(index);
            currentStatus = checkboxesPage.getCheckboxCurrentValue(index);
            Assert.assertEquals(currentStatus, expectedStatus);
        });
    }
}