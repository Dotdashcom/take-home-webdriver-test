package com.dotdash.test;

import com.dotdash.helper.Webdriver;
import com.dotdash.pageobject.CheckBoxPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckBoxes {

    private WebDriver chrome_driver = null;

    @BeforeClass
    public void init() {
        Webdriver web_driver = new Webdriver();
        chrome_driver = web_driver.get_chrome_driver();
        web_driver.open_page("checkboxes");
    }

    @Test(priority = 1)
    public void is_default_second_checkbox_selected() {
        CheckBoxPage check_box_page = new CheckBoxPage(chrome_driver);
        check_box_page.verify_second_checkbox_selected(true);
    }

    @Test(priority = 2)
    public void is_able_to_unselect_second_checkbox() {
        CheckBoxPage check_box_page = new CheckBoxPage(chrome_driver);
        check_box_page
                .click_second_checkbox()
                .verify_second_checkbox_selected(false);
    }

    @Test
    public void is_able_to_select_first_checkbox() {
        CheckBoxPage check_box_page = new CheckBoxPage(chrome_driver);
        check_box_page
                .click_first_checkbox()
                .verify_first_checkbox_selected(true);
    }

    @Test
    public void is_able_to_unselect_first_checkbox() {
        CheckBoxPage check_box_page = new CheckBoxPage(chrome_driver);
        check_box_page
                .click_first_checkbox()
                .verify_first_checkbox_selected(false);
    }

    @AfterClass
    public void tear_down() {
        chrome_driver.close();
        chrome_driver.quit();
    }
}
