package com.dotdash.test;

import com.dotdash.helper.Webdriver;
import com.dotdash.pageobject.JavaScriptAlertPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptAlert {

    private WebDriver chrome_driver = null;

    @BeforeClass
    void init() {
        Webdriver driver = new Webdriver();
        chrome_driver = driver.get_chrome_driver();
        driver.open_page("javascript_alerts");
    }

    @Test
    void able_to_trigger_js_alert() {
        JavaScriptAlertPage js_alert_page = new JavaScriptAlertPage(chrome_driver);
        js_alert_page
                .click_on_js_alert_btn()
                .accept_js_alert()
                .verify_text_after_accept_js_alert();
    }

    @Test
    void able_to_trigger_js_alert_confirm() {
        JavaScriptAlertPage js_alert_page = new JavaScriptAlertPage(chrome_driver);
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
    void able_to_trigger_js_prompt(){
        JavaScriptAlertPage js_alert_page = new JavaScriptAlertPage(chrome_driver);
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

    @AfterClass
    void tear_down() {
        chrome_driver.close();
        chrome_driver.quit();
    }
}
