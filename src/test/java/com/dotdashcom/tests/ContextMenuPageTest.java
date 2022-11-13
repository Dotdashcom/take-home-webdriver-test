package com.dotdashcom.tests;

import com.dotdashcom.MainTest;
import com.dotdashcom.pagemodels.ContextMenuPageModel;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ContextMenuPageTest extends MainTest {

    public static final String JAVASCRIPT_ALERT_TEXT = "You selected a context menu";
    ContextMenuPageModel page;

    private void init() {
        page = new ContextMenuPageModel(driver);
        driver.get(BASE_URL + ContextMenuPageModel.PAGE_URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.of(5L, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(page.getHotSpotDivElement()));
    }

    @Test
    void WHEN_right_click_element_THEN_javascript_alert() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(ContextMenuPageModel.PAGE_URL));

        page.hotSpotRightClick();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), JAVASCRIPT_ALERT_TEXT, "Alert message is not as expected.");

    }
}
