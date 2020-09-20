package com.dotdash.test;


import com.dotdash.helper.Webdriver;
import com.dotdash.pageobject.DynamicControlPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicControl {

    private WebDriver chrome_driver = null;

    @BeforeClass
    void init() {
        Webdriver driver = new Webdriver();
        chrome_driver = driver.get_chrome_driver();
        driver.open_page("dynamic_controls");
    }

    @Test
    void able_to_remove_checkbox() {
        DynamicControlPage dynamic_control_page = new DynamicControlPage(chrome_driver);
        dynamic_control_page
                .click_on_remove_checkbox_button()
                .verify_checkbox_is_removed();
    }

    @Test
    void able_to_enable_textfield(){
        DynamicControlPage dynamic_control_page = new DynamicControlPage(chrome_driver);
        dynamic_control_page
                .click_to_enable_text_field()
                .verify_text_field_is_enabled();
    }

    @AfterClass
    void tear_down() {
        chrome_driver.close();
        chrome_driver.quit();
    }
}
