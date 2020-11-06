package PageRepositories;

import Tests.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Login extends PageUtils {

    public WebDriver driver;

    //Constructor
    public Login (WebDriver driver) {this.driver = driver;}

    //*****************************
    //**********Login Page*********
    //*****************************
    //
    //**********Login Elements*****

    String login_url_path = "/login";
    String header_login_page = "//h2";
    String Header_login_page_text = "Login Page";
    String input_username = "//input[contains(@id,'username')]";
    String input_password = "//input[contains(@id,'password')]";
    String button_login = "//button[contains(@type,'submit')]/i";
    String header_secure_area = "//h2";
    String header_secure_area_text = "Secure Area";
    String button_logout = "//a[contains(@href,'logout')]/i";
    String invalid_login_message = "//div[contains(@id,'flash-message')]";

    //******Login Page Methods*****
    @Step("Navigate to Login Page")
    public void navigate_to_login_page(String base_url) {
        driver.get(base_url + login_url_path);
        wait_for_element_present(driver, input_password);
        wait_for_element_present(driver, input_username);
    }

    @Step("Validate the Login Page Header is Present")
    public void validate_login_page_header() {
        verify_text_present(driver, header_login_page,Header_login_page_text, "Login Page Header Is Not Matched.");
    }

    @Step("Enter the User Name - [{0}]")
    public void enter_user_name(String user_name) {
        type_in_field(driver,input_username,user_name);
    }

    //This is used for default config file
    @Step("Enter the Password")
    public void enter_user_password() throws IOException {
        BaseTest baseTest = new BaseTest();
        type_in_field(driver,input_password,baseTest.getPassword());
    }

    //This can be used in general
    @Step("Enter the Password")
    public void enter_user_password(String password) {
        type_in_field(driver,input_password,password);
    }

    @Step("Click Login Button")
    public void click_login_button() {
        click_element(driver,button_login);
    }

    @Step("Verify Successful Login to Secure Area")
    public void verify_login_to_secure_area_page() {
        verify_text_present(driver,header_secure_area,header_secure_area_text,"Unable to Login. Please check the Credentials.");
        verify_element_is_present(driver,button_logout);
    }

    //The parameter "test_scope" is used for the result log purpose that will show in allure report
    @Step("Invalid Login - [{0}]")
    public void invalid_login_check(String test_scope, String expected_string) {
        verify_text_present(driver,invalid_login_message,expected_string,"Incorrect Error Message.");
    }
}
