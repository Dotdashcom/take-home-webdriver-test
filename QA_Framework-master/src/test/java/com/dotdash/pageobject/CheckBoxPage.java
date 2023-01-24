package com.dotdash.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CheckBoxPage extends BasePageObject {

    private final By check_boxes = By.cssSelector("#checkboxes > input");

    private final int FIRST_CHECK_BOX_INDEX = 0;
    private final int SECOND_CHECK_BOX_INDEX = 1;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        open_page("checkboxes");
    }

    private List<WebElement> checkboxes_elems() {
        return this.driver.findElements(check_boxes);
    }

    public CheckBoxPage click_first_checkbox() {
        this.checkboxes_elems().get(this.FIRST_CHECK_BOX_INDEX).click();
        return this;
    }

    public CheckBoxPage click_second_checkbox() {
        this.checkboxes_elems().get(this.SECOND_CHECK_BOX_INDEX).click();
        return this;
    }

    public CheckBoxPage verify_first_checkbox_selected(boolean isSelected) {
        if (isSelected) {
            Assert.assertTrue(this.checkboxes_elems().get(this.FIRST_CHECK_BOX_INDEX).isSelected());
        } else {
            Assert.assertFalse(this.checkboxes_elems().get(this.FIRST_CHECK_BOX_INDEX).isSelected());
        }
        return this;
    }

    public CheckBoxPage verify_second_checkbox_selected(boolean isSelected) {
        if (isSelected) {
            Assert.assertTrue(this.checkboxes_elems().get(this.SECOND_CHECK_BOX_INDEX).isSelected());
        } else {
            Assert.assertFalse(this.checkboxes_elems().get(this.SECOND_CHECK_BOX_INDEX).isSelected());
        }
        return this;
    }
}
