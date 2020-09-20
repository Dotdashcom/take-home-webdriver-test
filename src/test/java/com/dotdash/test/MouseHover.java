package com.dotdash.test;

import com.dotdash.helper.Webdriver;
import com.dotdash.pageobject.MouseHoverPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseHover {
    private WebDriver chrome_driver = null;

    @BeforeClass
    void init() {
        Webdriver driver = new Webdriver();
        chrome_driver = driver.get_chrome_driver();
        driver.open_page("hovers");
    }

    @Test
    void able_to_hover_and_see_user_info() {
        MouseHoverPage mouse_hover_page = new MouseHoverPage(chrome_driver);
        mouse_hover_page.mouse_over_user(1).verify_general_info_for_user(1);
        mouse_hover_page.mouse_over_user(2).verify_general_info_for_user(2);
        mouse_hover_page.mouse_over_user(3).verify_general_info_for_user(3);
    }

    @AfterClass
    void tear_down() {
        chrome_driver.close();
        chrome_driver.quit();
    }
}
