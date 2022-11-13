package com.dotdashcom.tests;

import com.dotdashcom.MainTest;
import com.dotdashcom.pagemodels.DynamicControlsPageModel;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DynamicControlsPageTest extends MainTest {

    public static final String EXPECTED_TEXT_WHEN_FIELD_ENABLED = "It's enabled!";
    public static final String EXPECTED_TEXT_WHEN_FIELD_DISABLED = "It's disabled!";
    DynamicControlsPageModel page;

    private void init() {
        page = new DynamicControlsPageModel(driver);
        driver.get(BASE_URL + DynamicControlsPageModel.PAGE_URL);
    }

    @Test
    void WHEN_click_remove_button_THEN_checkbox_cannot_be_found_WHEN_click_add_button_THEN_checkbox_found() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(DynamicControlsPageModel.PAGE_URL));

        // Expecting one element with id=checkbox
        Assert.assertEquals(page.findAllElementsWithId("checkbox").size(), 1);

        // Clicking on Remove button and looking for our checkbox again
        page.getRemoveButton().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.invisibilityOf(page.getCheckbox()));
        // Expecting no elements with id=checkbox
        Assert.assertEquals(page.findAllElementsWithId("checkbox").size(), 0);

        // Clicking on Add button and looking for our checkbox again
        page.getAddButton().click();
        wait.until(ExpectedConditions.visibilityOf(page.getCheckbox()));
        // Expecting one element with id=checkbox
        Assert.assertEquals(page.findAllElementsWithId("checkbox").size(), 1);
    }

    @Test
    void WHEN_click_enable_button_THEN_text_field_enabled_WHEN_click_disable_button_THEN_text_field_disabled() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(DynamicControlsPageModel.PAGE_URL));

        // Clicking on the Enable button and checking if the text field becomes enabled
        page.getEnableButton().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.textToBePresentInElement(page.getMessage(), EXPECTED_TEXT_WHEN_FIELD_ENABLED));
        Assert.assertTrue(page.getTextField().isEnabled());

        // Clicking on the Disable button and checking if the text field becomes disabled
        page.getDisableButton().click();
        wait.until(ExpectedConditions.textToBePresentInElement(page.getMessage(), EXPECTED_TEXT_WHEN_FIELD_DISABLED));
        Assert.assertFalse(page.getTextField().isEnabled());
    }
}
