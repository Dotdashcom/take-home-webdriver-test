package com.dotdash.test;

import com.dotdash.helper.Webdriver;
import com.dotdash.pageobject.OpenNewWindowPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenNewWindow {

    private WebDriver chrome_driver;

    @BeforeClass
    void init() {
        Webdriver driver = new Webdriver();
        chrome_driver = driver.get_chrome_driver();
        driver.open_page("windows");
    }

    @Test
    void able_to_open_new_window_tab() {
        OpenNewWindowPage open_new_window_page = new OpenNewWindowPage(chrome_driver);
        open_new_window_page
                .click_on_hyperlink_to_open_new_tab()
                .verify_text_on_new_window("New Window");
    }

    @AfterClass
    void tear_down(){
        chrome_driver.close();
        chrome_driver.quit();
    }
}
