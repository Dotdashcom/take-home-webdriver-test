package com.dotdash.test;

import com.dotdash.helper.Webdriver;
import com.dotdash.pageobject.DnDPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DnD {
    private WebDriver chrome_driver;

    @BeforeClass
    void init() {
        Webdriver web_driver = new Webdriver();
        chrome_driver = web_driver.get_chrome_driver();
        web_driver.open_page("drag_and_drop");
    }

    @Test
    void able_to_dnd_left_to_right() throws Exception {
        DnDPage dnd_page = new DnDPage(chrome_driver);
        dnd_page.dnd_left_to_right().verify_text_after_dnd();
    }

    @Test
    void able_to_dnd_right_to_left() throws Exception {
        DnDPage dnd_page = new DnDPage(chrome_driver);
        dnd_page.dnd_right_to_left().verify_text_after_dnd();
    }

    @AfterClass
    void tear_down() {
        chrome_driver.close();
        chrome_driver.quit();
    }
}
