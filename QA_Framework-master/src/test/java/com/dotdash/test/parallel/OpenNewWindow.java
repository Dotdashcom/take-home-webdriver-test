package com.dotdash.test.parallel;

import com.dotdash.pageobject.OpenNewWindowPage;
import com.dotdash.test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenNewWindow extends BaseTest {
    private OpenNewWindowPage open_new_window_page = null;

    @BeforeMethod
    void init() {
        if (open_new_window_page == null) open_new_window_page = new OpenNewWindowPage(driver);
    }

    @Test
    void able_to_open_new_window_tab() {
        open_new_window_page
                .click_on_hyperlink_to_open_new_tab()
                .verify_text_on_new_window("New Window");
    }
}
