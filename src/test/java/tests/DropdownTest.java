package tests;

import model.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class DropdownTest extends BaseTest {

    @Test
    public void testSelectDropdownMenuOptionOne() {
        DropdownPage dropdownPage = new DropdownPage(getDriver())
                .getDropdownPage();
        if(dropdownPage.getDropdownMenuSelectedOptionText()
                .equals(dropdownPage.getDropdownMenuOptionOneText())) {
            dropdownPage.selectDropdownMenuOptionTwo();
        }
        String expectedSelectedOption = dropdownPage
                .selectDropdownMenuOptionOne()
                .getDropdownMenuOptionOneText();

        String actualSelectedOption = dropdownPage
                .selectDropdownMenuOptionOne()
                .getDropdownMenuSelectedOptionText();

        Assert.assertEquals(actualSelectedOption, expectedSelectedOption);
    }

    @Test
    public void testSelectDropdownMenuOptionTwo() {
        DropdownPage dropdownPage = new DropdownPage(getDriver())
                .getDropdownPage();
        if(dropdownPage.getDropdownMenuSelectedOptionText()
                .equals(dropdownPage.getDropdownMenuOptionTwoText())) {
            dropdownPage.selectDropdownMenuOptionOne();
        }
        String expectedSelectedOption = dropdownPage
                .selectDropdownMenuOptionTwo()
                .getDropdownMenuOptionTwoText();

        String actualSelectedOption = dropdownPage
                .selectDropdownMenuOptionTwo()
                .getDropdownMenuSelectedOptionText();

        Assert.assertEquals(actualSelectedOption, expectedSelectedOption);
    }

    @Test
    public void testIsDropdownMenuPlaceholderOptionSelectedByDefault() {
        boolean isPlaceholderOptionSelected = new DropdownPage(getDriver())
                .getDropdownPage()
                .isPlaceholderOptionSelected();

        Assert.assertTrue(isPlaceholderOptionSelected);
    }

    @Test
    public void testSelectDropdownMenuPlaceholderOption() {
        boolean isPlaceholderOptionSelected = new DropdownPage(getDriver())
                .getDropdownPage()
                .selectDropdownMenuOptionOne()
                .selectDropdownMenuPlaceholderOption()
                .isPlaceholderOptionSelected();

        Assert.assertFalse(isPlaceholderOptionSelected);
    }

    @Test
    public void testHeaderText() {
        String expectedText = "Dropdown List";

        String actualText = new DropdownPage(getDriver())
                .getDropdownPage()
                .getHeaderText();

        Assert.assertEquals(actualText, expectedText);
    }
}