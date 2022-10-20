package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITests;
import codingchallengewebsite.ui.pageobjects.CheckboxesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest extends UITests {

    public CheckboxesTest() {
    }

    @Test(description="Checkboxes can be checked and unchecked")
    public void checkboxChecking() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(this.driver, this);
        Assert.assertTrue(checkboxesPage.isPageOpen(), "Page not open");

        // Perform check / uncheck
        checkboxesPage.clickCheckbox("checkbox1");
        checkboxesPage.clickCheckbox("checkbox2");

        // Assertion to validate checkboxes were properly checked / unchecked
        Assert.assertEquals(checkboxesPage.isCheckboxSelected("checkbox1"), checkboxesPage.getCheckbox1Expected());
        Assert.assertEquals(checkboxesPage.isCheckboxSelected("checkbox2"), checkboxesPage.getCheckbox2Expected());

        // Perform check / uncheck
        checkboxesPage.clickCheckbox("checkbox1");
        checkboxesPage.clickCheckbox("checkbox2");

        // Assertion to validate checkboxes were properly checked / unchecked to their initial state
        Assert.assertNotEquals(checkboxesPage.isCheckboxSelected("checkbox1"), checkboxesPage.getCheckbox1Expected());
        Assert.assertNotEquals(checkboxesPage.isCheckboxSelected("checkbox2"), checkboxesPage.getCheckbox2Expected());
    }
}
