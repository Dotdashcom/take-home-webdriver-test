package com.dotdashcom.tests;

import com.dotdashcom.MainTest;
import com.dotdashcom.pagemodels.CheckboxesPageModel;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

public class CheckboxesPageTest extends MainTest {

    CheckboxesPageModel page;

    private void init() {
        page = new CheckboxesPageModel(driver);
        driver.get(BASE_URL + CheckboxesPageModel.PAGE_URL);
    }

    @Test
    void WHEN_click_checkbox_THEN_checkbox_state_changes() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(CheckboxesPageModel.PAGE_URL));

        List<WebElement> checkboxes = page.findCheckboxes();

        ofNullable(checkboxes).orElse(emptyList()).stream()
                .forEach(c -> {
                    boolean isSelected = c.isSelected();
                    c.click();
                    Assert.assertFalse(c.isSelected() == isSelected);
                });
    }
}
