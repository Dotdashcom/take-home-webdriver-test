package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownPageTest extends TestConfiguration {

    @Test
    @Parameters({"baseUrl", "dropdownUrl","OptionOneText","OptionTwoText"})
    public void dropDown_Test(String baseUrl, String dropdownUrl, String OptionOneText, String OptionTwoText) {
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.goToUrl(baseUrl , dropdownUrl);

        dropdownPage.selectOption("Option 1");
        Assert.assertTrue(dropdownPage.getSelectedOptionText().equals(OptionOneText));
        dropdownPage.selectOption("Option 2");
        Assert.assertTrue(dropdownPage.getSelectedOptionText().equals(OptionTwoText));
    }
}
