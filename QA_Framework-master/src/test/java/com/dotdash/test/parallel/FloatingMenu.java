package com.dotdash.test.parallel;

import com.dotdash.pageobject.FloatingMenuPage;
import com.dotdash.test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FloatingMenu extends BaseTest {

    private FloatingMenuPage floating_menu_page = null;

    @BeforeMethod
    void init() {
        if (floating_menu_page == null) floating_menu_page = new FloatingMenuPage(driver);
    }

    @Test
    void scroll_and_check_menu_floating() {
        floating_menu_page
                .scroll_to_bottom()
                .verify_menu_is_still_displayed_on_top();
    }
}
