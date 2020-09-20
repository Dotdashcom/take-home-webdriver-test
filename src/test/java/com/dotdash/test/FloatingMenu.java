package com.dotdash.test;

import com.dotdash.helper.Webdriver;
import com.dotdash.pageobject.FloatingMenuPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FloatingMenu {

    private WebDriver chrome_driver = null;

    @BeforeClass
    void init() {
        Webdriver driver = new Webdriver();
        chrome_driver = driver.get_chrome_driver();
        driver.open_page("floating_menu");
    }

    @Test
    void scroll_and_check_menu_floating() {
        FloatingMenuPage floating_menu_page = new FloatingMenuPage(chrome_driver);
        floating_menu_page
                .scroll_to_bottom()
                .verify_menu_is_still_displayed_on_top();
    }

    @AfterClass
    void tear_down() {
        chrome_driver.close();
        chrome_driver.quit();
    }
}
