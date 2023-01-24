package com.dotdash.test.parallel;

import com.dotdash.pageobject.CheckBoxPage;
import com.dotdash.test.BaseTest;
import org.testng.annotations.*;

@Test
public class CheckBoxes extends BaseTest {

    private CheckBoxPage check_box_page;

    @BeforeMethod
    void init_page_objects() {
        if (check_box_page == null) check_box_page = new CheckBoxPage(driver);
    }

    @Test(priority = 1)
    public void is_default_second_checkbox_selected() {
        check_box_page.verify_second_checkbox_selected(true);
    }

    @Test(priority = 2)
    public void is_able_to_unselect_second_checkbox() {
        check_box_page
                .click_second_checkbox()
                .verify_second_checkbox_selected(false);
    }

    public void is_able_to_select_first_checkbox() {
        check_box_page
                .click_first_checkbox()
                .verify_first_checkbox_selected(true);
    }

    public void is_able_to_unselect_first_checkbox() {
        check_box_page
                .click_first_checkbox()
                .verify_first_checkbox_selected(false);
    }
}
