package com.dotdash.test.parallel;

import com.dotdash.pageobject.JavaScriptAlertPage;
import com.dotdash.test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptAlert extends BaseTest {

    private JavaScriptAlertPage js_alert_page = null;

    @BeforeMethod
    void init() {
        if (js_alert_page == null) js_alert_page = new JavaScriptAlertPage(driver);
    }

    @Test
    void able_to_trigger_js_alert() {
        js_alert_page
                .click_on_js_alert_btn()
                .accept_js_alert()
                .verify_text_after_accept_js_alert();
    }

    @Test
    void able_to_trigger_js_alert_confirm() {
        // Cancel the JS Confirm
        js_alert_page
                .click_on_js_confirm_btn()
                .dismiss_js_confirm()
                .verify_text_after_cancel_js_confirm();

        // OK the JS Confirm
        js_alert_page
                .click_on_js_confirm_btn()
                .accept_js_confirm()
                .verify_text_after_accept_js_confirm();
    }

    @Test
    void able_to_trigger_js_prompt() {
        js_alert_page
                .click_on_js_prompt_btn()
                .accept_js_prompt()
                .verify_text_result_after_accept_with_text_js_prompt();

        js_alert_page
                .click_on_js_prompt_btn()
                .accept_js_prompt("able_to_trigger_js_prompt")
                .verify_text_result_after_accept_with_text_js_prompt("able_to_trigger_js_prompt");

        js_alert_page
                .click_on_js_prompt_btn()
                .dismiss_js_prompt()
                .verify_text_result_after_dismiss_js_prompt();
    }
}
