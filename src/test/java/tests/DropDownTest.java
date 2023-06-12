package tests;

import org.testng.annotations.Test;
import pages.DropDownPage;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class DropDownTest extends BaseTest{
    @Test
    public void selectFirstValueInDropdown() {
        HomePage homePage= new HomePage(driver);
        DropDownPage dropDown = homePage.clickDropDown();
        dropDown.selectValueFromDropdown("Option 1");
        assertEquals(dropDown.getTextFromSelectedValueInDropdown(), "Option 1");
    }

    @Test
    public void selectSecondValueInDropdown() {
        HomePage homePage= new HomePage(driver);
        DropDownPage dropDown = homePage.clickDropDown();
        dropDown.selectValueFromDropdown("Option 2");
        assertEquals(dropDown.getTextFromSelectedValueInDropdown(), "Option 2");
    }
}
