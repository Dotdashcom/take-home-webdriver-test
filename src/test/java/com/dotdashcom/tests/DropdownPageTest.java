package com.dotdashcom.tests;

import com.dotdashcom.MainTest;
import com.dotdashcom.pagemodels.DropdownPageModel;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

public class DropdownPageTest extends MainTest {

    public static final int EXPECTED_NUMBER_OF_OPTIONS_IN_DROPDOWN = 3;
    public static final String EXPECTED_OPTION_1_TEXT = "Option 1";
    public static final String EXPECTED_OPTION_2_TEXT = "Option 2";

    DropdownPageModel page;

    private void init() {
        page = new DropdownPageModel(driver);
        driver.get(BASE_URL + DropdownPageModel.PAGE_URL);
    }

    @Test(testName = "WHEN_select_option_THEN_option_is_selected")
    void WHEN_select_option_THEN_option_is_selected() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(DropdownPageModel.PAGE_URL));

        List<WebElement> options = page.compileDropdownOptions(page.getDropdown());

        // How many options in our dropdown
        Assert.assertEquals(options.size(), EXPECTED_NUMBER_OF_OPTIONS_IN_DROPDOWN);

        // Choose each option and check if it got selected
        ofNullable(options).orElse(emptyList()).stream()
                .forEach(o -> {
                    if (!o.isSelected()) {
                        o.click();
                        Assert.assertTrue(o.isSelected());
                    }
                });

        // Check option texts
        Assert.assertEquals(options.get(1).getText(), EXPECTED_OPTION_1_TEXT, "The option text doesn't match expected text.");
        Assert.assertEquals(options.get(2).getText(), EXPECTED_OPTION_2_TEXT, "The option text doesn't match expected text.");
    }
}
