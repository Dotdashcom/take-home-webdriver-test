package com.dotdash.test.parallel;

import com.dotdash.pageobject.DynamicControlPage;
import com.dotdash.test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicControl extends BaseTest {

    private DynamicControlPage dynamic_control_page = null;

    @BeforeMethod
    void init() {
        if (dynamic_control_page == null) dynamic_control_page = new DynamicControlPage(driver);
    }

    @Test
    void able_to_remove_checkbox() {
        dynamic_control_page
                .click_on_remove_checkbox_button()
                .verify_checkbox_is_removed();
    }

    @Test
    void able_to_enable_textfield() {
        dynamic_control_page
                .click_to_enable_text_field()
                .verify_text_field_is_enabled();
    }
}
