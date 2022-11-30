package com.dotdash;

import com.dotdash.basetest.BaseTest;
import com.dotdash.pageobjects.GeneratePage;
import com.dotdash.pageobjects.JavaScriptAlertsPage;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JavaScriptAlertTests extends BaseTest {

    @Test
    public void shouldShowJSAlert() {
        JavaScriptAlertsPage javaScriptAlertsPage = GeneratePage.javaScriptAlertsPage().goToJavaScriptAlertsPage().clickAlertButton();

        assertThat(javaScriptAlertsPage.getAlertMessage(), is("I am a JS Alert"));
    }

    @Test
    public void shouldConfirmJsAlert() {
        JavaScriptAlertsPage javaScriptAlertsPage = GeneratePage.javaScriptAlertsPage().goToJavaScriptAlertsPage().clickConfirmButton();

        assertThat(javaScriptAlertsPage.getResultMessage(), is("You clicked: Ok"));
    }

    @Test
    public void shouldTypeInJsAlert() {
        String message = "PROMPT TEST";
        JavaScriptAlertsPage javaScriptAlertsPage = GeneratePage.javaScriptAlertsPage().goToJavaScriptAlertsPage().clickPromptButton().writeToAlert(message);

        assertThat(javaScriptAlertsPage.getResultMessage(), is("You entered: " + message));
    }
}
