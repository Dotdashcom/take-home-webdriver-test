package com.dotdash.test.parallel;

import com.dotdash.pageobject.MouseHoverPage;
import com.dotdash.test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHover extends BaseTest {
    private MouseHoverPage mouse_hover_page = null;

    @BeforeMethod
    void init() {
        if (mouse_hover_page == null) mouse_hover_page = new MouseHoverPage(driver);
    }

    @Test
    void able_to_hover_and_see_user_info() {
        mouse_hover_page.mouse_over_user(1).verify_general_info_for_user(1);
        mouse_hover_page.mouse_over_user(2).verify_general_info_for_user(2);
        mouse_hover_page.mouse_over_user(3).verify_general_info_for_user(3);
    }
}
