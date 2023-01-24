package com.dotdash.test.parallel;

import com.dotdash.pageobject.DropDownListPage;
import com.dotdash.test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownList extends BaseTest {

    private DropDownListPage dropdown_list_page = null;

    @BeforeMethod
    void init() {
        if (dropdown_list_page == null) dropdown_list_page = new DropDownListPage(driver);
    }

    @Test
    void able_to_select_option() {
        final String OPTION_01 = "Option 1";
        final String OPTION_02 = "Option 2";
        dropdown_list_page
                .select_option(OPTION_01)
                .verify_selected_option(OPTION_01)
                .select_option(OPTION_02)
                .verify_selected_option(OPTION_02);
    }

}
