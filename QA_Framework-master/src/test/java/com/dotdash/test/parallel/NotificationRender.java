package com.dotdash.test.parallel;

import com.dotdash.pageobject.NotificationRenderPage;
import com.dotdash.pageobject.OpenNewWindowPage;
import com.dotdash.test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotificationRender extends BaseTest {
    private NotificationRenderPage NotificationRenderPage = null;

    @BeforeMethod
    void init() {
        if (NotificationRenderPage == null) NotificationRenderPage = new NotificationRenderPage(driver);
    }

    @Test
    void able_to_open_new_window_tab() throws InterruptedException {
        NotificationRenderPage.verifynotificationpage();
    }
}
