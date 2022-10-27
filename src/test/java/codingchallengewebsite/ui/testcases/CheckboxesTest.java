package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITest;
import codingchallengewebsite.ui.pageobjects.CheckboxesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest extends UITest {
    private int index;
    public CheckboxesTest() { }
    @Test(description="Checkboxes can be checked and unchecked")
    public void checkboxChecking() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(this);
        Boolean prevStatus, currentStatus, expectedStatus;

        // Validate page loaded
        Assert.assertTrue(checkboxesPage.isPageOpen(), "Page not open");

        // All checkboxes toggled back and forth
        index = checkboxesPage.checkboxElements.listIterator(0).nextIndex();
        while (index>0) {
            prevStatus = checkboxesPage.clickOnCheckbox(index);
            currentStatus = checkboxesPage.getCheckboxCurrentValue(index);
            Assert.assertNotEquals(prevStatus, currentStatus);
            expectedStatus = checkboxesPage.getCheckboxExpectedValue(index);
            checkboxesPage.clickOnCheckbox(index);
            currentStatus = checkboxesPage.getCheckboxCurrentValue(index);
            Assert.assertEquals(currentStatus, expectedStatus);
        }
    }
}