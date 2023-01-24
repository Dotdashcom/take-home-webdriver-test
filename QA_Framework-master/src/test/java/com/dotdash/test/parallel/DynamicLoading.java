package com.dotdash.test.parallel;

import com.dotdash.pageobject.DynamicLoadingPage;
import com.dotdash.test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicLoading extends BaseTest {

    private DynamicLoadingPage dynamic_loading_page = null;

    @BeforeMethod
    void init() {
        if (dynamic_loading_page == null) dynamic_loading_page = new DynamicLoadingPage(driver);
    }

    @Test
    void able_to_load_new_text() {
        dynamic_loading_page
                .click_on_start_btn()
                .verify_hello_world_displayed();
    }

}
