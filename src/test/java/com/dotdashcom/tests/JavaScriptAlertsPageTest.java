package com.dotdashcom.tests;

import com.dotdashcom.MainTest;
import com.dotdashcom.pagemodels.JavaScriptAlertsPageModel;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlertsPageTest extends MainTest {

    public static final String JAVASCRIPT_ALERT_TEXT = "I am a JS Alert";
    public static final String RESULT_ALERT_TEXT = "You successfuly clicked an alert";
    public static final String JAVASCRIPT_CONFIRM_TEXT = "I am a JS Confirm";
    public static final String RESULT_CONFIRM_TEXT = "You clicked: Ok";
    public static final String JAVASCRIPT_PROMPT_TEXT = "I am a JS prompt";
    public static final String TYPED_IN_TEST_TEXT = "Some test text";
    JavaScriptAlertsPageModel page;

    private void init() {
        page = new JavaScriptAlertsPageModel(driver);
        driver.get(BASE_URL + JavaScriptAlertsPageModel.PAGE_URL);
    }

    @Test
    void WHEN_clicking_on_buttons_THEN_javascript_alert_confirm_prompt_displayed() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(JavaScriptAlertsPageModel.PAGE_URL));

        // Testing JavaScript Alert
        page.getAlertButton().click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), JAVASCRIPT_ALERT_TEXT, "Alert message is not as expected.");
        alert.accept();
        Assert.assertTrue(page.getResultParagraphElement().getText().contains(RESULT_ALERT_TEXT));

        // Testing JavaScript Confirm
        page.getConfirmButton().click();
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), JAVASCRIPT_CONFIRM_TEXT, "Confirm message is not as expected.");
        alert.accept();
        Assert.assertTrue(page.getResultParagraphElement().getText().contains(RESULT_CONFIRM_TEXT));

        // Testing JavaScript Prompt
        page.getPromptButton().click();
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), JAVASCRIPT_PROMPT_TEXT, "Prompt message is not as expected.");
        // Typing into the Prompt window
        alert.sendKeys(TYPED_IN_TEST_TEXT);
        alert.accept();
        Assert.assertTrue(page.getResultParagraphElement().getText().contains(TYPED_IN_TEST_TEXT));
    }
}
