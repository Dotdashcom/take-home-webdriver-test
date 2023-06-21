package com.example.cucumber.page.javaScriptError;

import com.example.navigation.WebDriverJavaUtil;
import com.example.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

import java.util.logging.Logger;

import static com.example.constants.Page.JAVASCRIPT_ERROR_PAGE;
import static com.example.constants.PageLinkText.JAVASCRIPT_ON_LOAD_ENVET_ERROR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JavaScriptErrorPage extends WebDriverJavaUtil {
    WebDriver driver;
    ReadProperties readProperties = new ReadProperties();
    Logger log = Logger.getLogger(JavaScriptErrorPage.class.getName());
    public JavaScriptErrorPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    private By javascript_error_page_link = By.linkText(JAVASCRIPT_ON_LOAD_ENVET_ERROR);
    private LogEntries logEntries;
    public void the_user_clicks_on_the_java_script_error_page() {
        clckOnWebElement(javascript_error_page_link);
    }

    public void the_user_should_see_the_java_script_error_page() {
        assertEquals("JavaScript Error Page URL doesn't Match: ", JAVASCRIPT_ERROR_PAGE, driver.getCurrentUrl());
    }

    public void the_user_verifies_that_there_is_a_java_script_error_on_the_java_script_error_page() {
        logEntries = driver.manage().logs().get("browser");
        assertTrue("JavaScript Error not found: ", logEntries.getAll().size()>0 );
    }

    public void the_user_should_see_the_javascript_error_on_the_java_script_error_page(String jsError) {
        boolean specificJSError = false;
        for (LogEntry entry : logEntries) {
            if (entry.getLevel().toString().equals("SEVERE") && entry.getMessage().contains(jsError)) {
                log.info("Console Error Log:");
                log.info("Message: " + entry.getMessage());
                specificJSError = true;
                break;
            }
        }
        String noSpecificError = "No Specific Error found: " + jsError + " : ";
        assertEquals(noSpecificError, true, specificJSError);
    }
}
