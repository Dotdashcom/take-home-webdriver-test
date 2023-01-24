package com.dotdash.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class DynamicControlPage extends BasePageObject{
    private final int WAIT_TIME = 10;

    private final By remove_checkbox_btn = By.xpath("//*[@id='checkbox-example']/button");
    private final By check_box = By.id("checkbox");
    private final By text_field = By.xpath("//*[@id='input-example']/input");
    private final By disable_textfield_btn = By.xpath("//*[@id='input-example']/button");

    public DynamicControlPage(WebDriver driver) {
        this.driver = driver;
        open_page("dynamic_controls");
    }

    public DynamicControlPage click_on_remove_checkbox_button() {
        driver.findElement(remove_checkbox_btn).click();
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(check_box));
        return this;
    }

    public void verify_checkbox_is_removed() {
        boolean is_checkbox_visible = true;
        try {
            driver.findElement(check_box).isDisplayed();
        } catch (Exception e) {
            is_checkbox_visible = false;
        }
        Assert.assertFalse(is_checkbox_visible, "[ERR] Checkbox is still display after " + WAIT_TIME + "s");
    }

    public DynamicControlPage click_to_enable_text_field() {
        driver.findElement(disable_textfield_btn).click();
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(text_field));
        return this;
    }

    public void verify_text_field_is_disable() {
        verify_text_field_state(false);
    }

    public void verify_text_field_is_enabled() {
        verify_text_field_state(true);
    }

    private void verify_text_field_state(boolean isEnable) {
        boolean is_textfield_enabled = isEnable;
        try {
            driver.findElement(text_field).isEnabled();
        } catch (Exception e) {
            is_textfield_enabled = !isEnable;
        }
        if (is_textfield_enabled) {
            Assert.assertTrue(is_textfield_enabled, "[ERR] Checkbox is still disable after " + WAIT_TIME + "s");
        } else {
            Assert.assertFalse(is_textfield_enabled, "[ERR] Checkbox is still enabled after " + WAIT_TIME + "s");
        }
    }
}
