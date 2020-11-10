package PageRepositories;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlerts extends PageUtils {

    public WebDriver driver;

    //Constructor
    public JavaScriptAlerts(WebDriver driver) {
        this.driver = driver;
    }

    //*************************************
    //**********JavaScript Alerts**********
    //*************************************
    //
    //******JavaScript Alerts Elements*****

    String javascript_alerts_url_path = "/javascript_alerts";
    String header_javascript_alerts_page = "//h3";
    String header_javascript_alerts_page_text = "JavaScript Alerts";
    String click_js_alert = "//button[contains(.,'JS Alert')]";
    String click_js_confirm = "//button[contains(.,'JS Confirm')]";
    String click_js_prompt = "//button[contains(.,'JS Prompt')]";

    String js_alert_text = "I am a JS Alert";
    String js_alert_result_text = "You successfuly clicked an alert";

    String js_confirm_text = "I am a JS Confirm";
    String js_confirm_result_text = "You clicked: Ok";

    String js_prompt_type = "This is a Test";
    String js_prompt_text = "I am a JS Prompt";
    String js_prompt_result_text = "You entered: "+ js_prompt_type;

    String result="//p[contains(@id,'result')]";

    //*****JavaScript Alerts Page Methods****
    @Step("Navigate to JavaScript Alerts Page")
    public void navigate_to_javascript_alerts_page(String base_url) {
        driver.get(base_url + javascript_alerts_url_path);
        wait_for_element_present(driver, header_javascript_alerts_page);
    }

    @Step("Validate the JavaScript Alerts Page Header is Present")
    public void validate_javascript_alerts_page_header() {
        verify_text_present(driver, header_javascript_alerts_page,header_javascript_alerts_page_text, "JavaScript Alerts Page Header Is Not Matched.");
    }

    @Step("Click JS Alert")
    public void click_js_alert() {
        verify_element_is_present(driver,click_js_alert);
        click_element(driver,click_js_alert);
        //custom_wait(1000);
    }

    @Step("Verify Alert Text, Click OK and Check Result")
    public void verify_js_alart() {
        verify_alert_message(driver,js_alert_text);
        //custom_wait(1000);
        accept_alert_message(driver);
        //custom_wait(1000);
        verify_text_present(driver, result, js_alert_result_text, "JS Click Result Message Not Matched");
    }

    @Step("Click JS Confirm")
    public void click_js_confirm() {
        verify_element_is_present(driver,click_js_confirm);
        click_element(driver,click_js_confirm);
        //custom_wait(2000);
    }

    @Step("Verify JS Confirm Alert Text, Click OK and Check Result")
    public void verify_js_confirm() {
        verify_alert_message(driver,js_confirm_text);
        accept_alert_message(driver);
        //custom_wait(1000);
        verify_text_present(driver, result, js_confirm_result_text, "JS Confirm Result Message Not Matched");
    }

    @Step("Click JS Prompt")
    public void click_js_prompt() {
        verify_element_is_present(driver,click_js_prompt);
        click_element(driver,click_js_prompt);
        //custom_wait(1000);
    }

    @Step("Type in JS Prompt")
    public void type_js_prompt() {
        verify_alert_message(driver,js_prompt_text);
        type_in_alert(driver,js_prompt_type);
        accept_alert_message(driver);
        //custom_wait(2000);
    }

    @Step("Verify JS Prompt Text in Result")
    public void verify_js_prompt_result() {
        verify_text_present(driver, result, js_prompt_result_text, "JS Prompt Result Message Not Matched");
    }
}