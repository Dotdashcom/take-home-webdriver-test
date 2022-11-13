package com.dotdashcom.tests;

import com.dotdashcom.MainTest;
import com.dotdashcom.pagemodels.IFramePageModel;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class IFramePageTest extends MainTest {

    public static final String TEST_TEXT = "This is a test text.";
    IFramePageModel page;

    private void init() {
        page = new IFramePageModel(driver);
        driver.get(BASE_URL + IFramePageModel.PAGE_URL);
    }

    @Test
    void WHEN_enter_text_to_iframe_THEN_text_is_entered() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(IFramePageModel.PAGE_URL));

        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOf(page.getIFrame()));

        driver.switchTo().frame(page.getIFrame());

        wait.until(ExpectedConditions.visibilityOf(page.getEditor()));

        page.getEditor().sendKeys(TEST_TEXT);
        Assert.assertTrue(page.getEditor().getText().contains(TEST_TEXT), "Expected text is not available.");
    }
}
