package com.dotdashcom.tests;

import com.dotdashcom.MainTest;
import com.dotdashcom.pagemodels.DynamicLoadingPageModel;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DynamicLoadingPageTest extends MainTest {

    public static final String EXPECTED_TEXT_IN_FINISH_DIV = "Hello World!";
    DynamicLoadingPageModel page;

    private void init() {
        page = new DynamicLoadingPageModel(driver);
        driver.get(BASE_URL + DynamicLoadingPageModel.PAGE_URL);
    }

    @Test
    void WHEN_click_start_button_THEN_text_displayed() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(DynamicLoadingPageModel.PAGE_URL));

        page.getStartButton().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOf(page.getFinishDiv()));
        Assert.assertEquals(page.getFinishDiv().getText(), EXPECTED_TEXT_IN_FINISH_DIV);
    }
}
