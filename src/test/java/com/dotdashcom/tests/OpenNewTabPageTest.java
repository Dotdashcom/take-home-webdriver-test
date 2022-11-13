package com.dotdashcom.tests;

import com.dotdashcom.MainTest;
import com.dotdashcom.pagemodels.OpenNewTabPageModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewTabPageTest extends MainTest {

    public static final String EXPECTED_TEXT_IN_NEW_WINDOW = "New Window";
    public static final String LINK_TEXT_CLICK_HERE = "Click Here";
    OpenNewTabPageModel page;

    private void init() {
        page = new OpenNewTabPageModel(driver);
        driver.get(BASE_URL + OpenNewTabPageModel.PAGE_URL);
    }

    @Test
    void WHEN_right_click_element_THEN_javascript_alert() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(OpenNewTabPageModel.PAGE_URL));

        String currentWindowHandle = driver.getWindowHandle();
        page.getContentDiv().findElement(By.linkText(LINK_TEXT_CLICK_HERE)).click();

        // Switch to the new browser tab, assuming that there are only 2 tabs
        String newWindowTabHandle = driver.getWindowHandles().stream()
                .filter(h -> !h.equals(currentWindowHandle)).findFirst().get();
        driver.switchTo().window(newWindowTabHandle);

        // Find expected text in the new browser tab
        Assert.assertTrue(page.getNewTabH3Element().getText().contains(EXPECTED_TEXT_IN_NEW_WINDOW),
                "Cannot find expected text in the new tab");
    }
}
