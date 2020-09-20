package com.dotdash.test;

import com.dotdash.helper.Webdriver;
import com.dotdash.pageobject.ContextMenuPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContextMenu {

    private WebDriver chrome_driver;

    @BeforeClass
    void init() {
        Webdriver web_driver = new Webdriver();
        chrome_driver = web_driver.get_chrome_driver();
        web_driver.open_page("context_menu");
    }

    @Test
    void able_to_click_on_target_area() throws Exception {
        ContextMenuPage context_menu_page = new ContextMenuPage(chrome_driver);
        context_menu_page
                .right_click_on_target_area()
                .is_alert_displayed();
    }

    @AfterClass
    void tear_down() {
        chrome_driver.close();
        chrome_driver.quit();
    }
}
