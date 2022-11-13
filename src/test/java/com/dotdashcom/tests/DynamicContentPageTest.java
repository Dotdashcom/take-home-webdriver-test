package com.dotdashcom.tests;

import com.dotdashcom.MainTest;
import com.dotdashcom.pagemodels.DynamicContentPageModel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicContentPageTest extends MainTest {

    public static final int NUMBER_OF_TIMES_TO_REFRESH_THE_PAGE = 10;
    DynamicContentPageModel page;

    private void init() {
        page = new DynamicContentPageModel(driver);
        driver.get(BASE_URL + DynamicContentPageModel.PAGE_URL);
    }

    @Test
    void WHEN_page_refreshed_THEN_new_content_loaded() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(DynamicContentPageModel.PAGE_URL));

        String contentBeforeRefresh = page.getContent().getText();
        String contentAfterRefresh = "";
        for (int i = 0; i < NUMBER_OF_TIMES_TO_REFRESH_THE_PAGE; i++) {
            page.refreshPage();
            contentAfterRefresh = page.getContent().getText();
            Assert.assertNotEquals(contentBeforeRefresh, contentAfterRefresh);
            contentBeforeRefresh = contentAfterRefresh;
        }
    }
}
