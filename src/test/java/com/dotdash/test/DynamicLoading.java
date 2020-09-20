package com.dotdash.test;

import com.dotdash.helper.Webdriver;
import com.dotdash.pageobject.DynamicLoadingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicLoading {

    private WebDriver chrome_driver = null;

    @BeforeClass
    void init() {
        Webdriver driver = new Webdriver();
        chrome_driver = driver.get_chrome_driver();
        driver.open_page("dynamic_loading/2");
    }

    @Test
    void able_to_load_new_text() {
        DynamicLoadingPage dynamic_loading_page = new DynamicLoadingPage(chrome_driver);
        dynamic_loading_page
                .click_on_start_btn()
                .verify_hello_world_displayed();
    }

    @AfterClass
    void tear_down() {
        chrome_driver.close();
        chrome_driver.quit();
    }
}
