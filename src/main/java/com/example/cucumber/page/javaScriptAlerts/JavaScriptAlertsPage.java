package com.example.cucumber.page.javaScriptAlerts;

import com.example.navigation.WebDriverJavaUtil;
import com.example.utils.ReadProperties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.example.constants.Page.JAVASCRIPT_ALERTS_PAGE;
import static com.example.constants.PageLinkText.JAVASCRIPT_ALERTS;
import static org.junit.Assert.assertEquals;

public class JavaScriptAlertsPage extends WebDriverJavaUtil {
    WebDriver driver;
    ReadProperties readProperties = new ReadProperties();
    By result_id = By.id("result");
    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By javascript_alerts_page_link = By.linkText(JAVASCRIPT_ALERTS);
    public void the_user_clicks_on_the_java_script_alerts_page() {
        clckOnWebElement(javascript_alerts_page_link);
    }

    public void the_user_should_see_the_java_script_alerts_page() {
        assertEquals("JavaScript Alert Page URL doesn't Match: ", JAVASCRIPT_ALERTS_PAGE, driver.getCurrentUrl());
    }

    public void the_user_clicks_on_the_on_the_java_script_alerts_page(String jsButton) {
        String jsAlertButtonXpath = "//button[contains(text(),'" + jsButton +"')]";
        clckOnWebElement(By.xpath(jsAlertButtonXpath));
        waitForMilliSeconds(2000);
    }

    public void the_user_should_see_the_alert_message_on_the_java_script_alerts_page(String jsAlertMessage) {
        Alert alert = driver.switchTo().alert();
        assertEquals("Invalid alert message: ", jsAlertMessage, alert.getText());
        alert.accept();
    }

    public void theUserShouldSeeEventConfirmationMessageOnTheJavaScriptAlertsPage(String confirmMsg) {
        assertEquals("Invalid success Message: ", confirmMsg, getWebElementText(result_id) );
    }

    public void theUserEntersOnTheJavaScriptPromptOnTheJavaScriptAlertsPage(String testMsg) {
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys(testMsg);
        promptAlert.accept();
    }
}
