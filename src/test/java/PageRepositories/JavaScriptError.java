package PageRepositories;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;

public class JavaScriptError extends PageUtils {

    public WebDriver driver;

    //Constructor
    public JavaScriptError(WebDriver driver) {
        this.driver = driver;
    }

    //*************************************
    //**********JavaScript Error**********
    //*************************************
    //
    //******JavaScript Error Elements*****

    String javascript_error_url_path = "/javascript_error";
    String error_text_in_page = "//p[contains(.,'JavaScript error')]";

    //*****JavaScript Error Page Methods****
    @Step("Navigate to JavaScript Error Page")
    public void navigate_to_javascript_error_page(String base_url) {
        driver.get(base_url + javascript_error_url_path);
        verify_element_is_present(driver, error_text_in_page);
    }

    @Step("Error Message is Present")
    public void error_message_is_present() { Assert.assertTrue(true, "Error Message is Not Present."); }

    @Step("Error Message is Not Present")
    public void error_message_is_not_present() { Assert.assertTrue(false, "Error Message is Not Present."); }

    //https://stackoverflow.com/questions/25431380/capturing-browser-logs-with-selenium-webdriver-using-java
    @Step("Verify the Error Log - {0}")
    public void verify_the_error_log(String error_text) {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        Boolean is_found = false;
        for (LogEntry entry : logEntries) {
            if (entry.getMessage().contains(error_text)) {
                is_found = true;
                break;
            }
        }
        if (is_found) {error_message_is_present();}
        else { error_message_is_not_present();}
    }
}