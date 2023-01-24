package com.dotdash.test.parallel;

import com.dotdash.pageobject.ContextMenuPage;
import com.dotdash.test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenu extends BaseTest {

    private ContextMenuPage context_menu_page = null;

    @BeforeMethod
    void init() {
        if (context_menu_page == null) context_menu_page = new ContextMenuPage(driver);
    }

    @Test
    void able_to_click_on_target_area() throws Exception {
        context_menu_page
                .right_click_on_target_area()
                .is_alert_displayed();
    }
}
