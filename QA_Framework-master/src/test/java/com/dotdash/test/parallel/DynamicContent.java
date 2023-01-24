package com.dotdash.test.parallel;

import com.dotdash.pageobject.DynamicContentPage;
import com.dotdash.test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicContent extends BaseTest {

    private DynamicContentPage dynamic_content_page = null;

    @BeforeMethod
    void init() {
        if (dynamic_content_page == null) dynamic_content_page = new DynamicContentPage(driver);
    }

    @Test
    void make_sure_dynamic_content_change() {
        final int TIME_TO_REFRESH = 3;
        dynamic_content_page.verify_content_change_after_refresh(TIME_TO_REFRESH);
    }

}
