package com.dotdash.test.parallel;

import com.dotdash.pageobject.JavaScriptErrorPage;
import com.dotdash.test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptError extends BaseTest {

    private JavaScriptErrorPage js_err_page = null;

    @BeforeMethod
    void init() {
        if (js_err_page == null) js_err_page = new JavaScriptErrorPage(driver);
    }

    @Test
    void able_to_detect_js_err_on_page() {
        js_err_page.verify_page_contains_js_error("Cannot read property 'xyz' of undefined");
    }
}
