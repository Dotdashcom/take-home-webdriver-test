package com.dotdash.test;

import com.dotdash.helper.Webdriver;
import com.dotdash.pageobject.JavaScriptErrorPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptError {

    private WebDriver chrome_driver = null;

    @BeforeClass
    void init() {
        Webdriver driver = new Webdriver();
        chrome_driver = driver.get_chrome_driver();
        driver.open_page("javascript_error");
    }

    @Test
    void able_to_detect_js_err_on_page() {
        JavaScriptErrorPage js_err_page = new JavaScriptErrorPage(chrome_driver);
        js_err_page.verify_page_contains_js_error("Cannot read property 'xyz' of undefined");
    }

    @AfterClass
    void tear_down() {
        chrome_driver.close();
        chrome_driver.quit();
    }
}
