package com.dotdash.test;

import com.dotdash.helper.Webdriver;
import com.dotdash.pageobject.DropDownListPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDownList {

    private WebDriver chrome_driver;

    @BeforeClass
    void init() {
        Webdriver driver = new Webdriver();
        chrome_driver = driver.get_chrome_driver();
        driver.open_page("dropdown");
    }

    @Test
    void able_to_select_option() {
        final String OPTION_01 = "Option 1";
        final String OPTION_02 = "Option 2";
        DropDownListPage dropdown_list_page = new DropDownListPage(chrome_driver);
        dropdown_list_page
                .select_option(OPTION_01)
                .verify_selected_option(OPTION_01)
                .select_option(OPTION_02)
                .verify_selected_option(OPTION_02);
    }

    @AfterClass
    void tear_down() {
        chrome_driver.close();
        chrome_driver.quit();
    }
}
