package scenarios;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.DropdownPage;


public class DropdownTest extends BaseTest {
    private DropdownPage dropdownPage;

    @BeforeMethod
    public void setup() {
        dropdownPage = homePage.gotoDropdownPage();
    }

    @DataProvider(name = "option-provider")
    public String[] getOptions() {
        return new String[] {"Option 1", "Option 2"};
    }

    @Test (dataProvider = "option-provider")
    public void selectOptionFromDefaultOption(String option) {
        String selectedOptionText = dropdownPage.selectOption(option)
                .getSelectedOptionText();

        Assert.assertEquals(selectedOptionText, option);
    }
}