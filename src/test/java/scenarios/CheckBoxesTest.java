package scenarios;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.CheckboxesPage;

import java.util.Arrays;


public class CheckBoxesTest extends BaseTest {
    private CheckboxesPage checkboxesPage;

    @BeforeMethod
    public void setup(Object[] testArgs) {
        checkboxesPage = homePage.gotoCheckboxesPage();

        // uncheck checkboxes
        for(int number : Arrays.copyOf(testArgs, testArgs.length, Integer[].class)){
            if(checkboxesPage.isCheckboxChecked(number) != false) {
                checkboxesPage.clickCheckbox(number);
            }
        }
    }

    @DataProvider (name = "checkbox-provider")
    public Integer[] getCheckBoxes() {
        return new Integer[] {1, 2};
    }

    @Test (dataProvider = "checkbox-provider")
    public void checkBoxTest(int number) {
        boolean isCheckboxChecked = checkboxesPage.clickCheckbox(number)
                .isCheckboxChecked(number);

        Assert.assertTrue(isCheckboxChecked, "Checkbox " + number + " should be checked!");
    }

    @Test (dataProvider = "checkbox-provider")
    public void uncheckBoxTest(int number) {
        boolean isCheckboxChecked = checkboxesPage.clickCheckbox(number)
                .clickCheckbox(number)
                .isCheckboxChecked(number);

        Assert.assertFalse(isCheckboxChecked, "Checkbox " + number + " should be unchecked!");
    }
}