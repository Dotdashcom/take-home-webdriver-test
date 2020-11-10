package PageRepositories;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DynamicControls extends PageUtils {

    public WebDriver driver;

    //Constructor
    public DynamicControls(WebDriver driver) {
        this.driver = driver;
    }

    //********************************
    //*****Dynamic Controls Menu******
    //********************************
    //
    //****Dynamic Controls Elements***

    String dynamic_controls_url_path = "/dynamic_controls";
    String header_dynamic_controls_page = "//h4";
    String header_dynamic_controls_page_text = "Dynamic Controls";
    String checkbox = "//input[contains(@type,'checkbox')]";
    String button_add = "//button[contains(@type,'button') and contains(.,'Add')]";
    String button_remove = "//button[contains(@type,'button') and contains(.,'Remove')]";
    String checkbox_remove_text = "//p[contains(@id,'message') and contains(.,'gone!')]";
    String checkbox_reappear_text = "//p[contains(@id,'message') and contains(.,'back!')]";
    String button_enable = "//button[contains(@type,'button') and contains(.,'Enable')]";
    String button_enable_text = "//p[contains(@id,'message') and contains(.,'enabled!')]";
    String button_disable = "//button[contains(@type,'button') and contains(.,'Disable')]";
    String button_disable_text = "//p[contains(@id,'message') and contains(.,'disabled!')]";
    String input_enable = "//input[contains(@type,'text')]";

    //*****Dynamic Controls Page Methods****
    @Step("Navigate to Dynamic Controls Page")
    public void navigate_to_dynamic_controls_page(String base_url) {
        driver.get(base_url + dynamic_controls_url_path);
        wait_for_element_present(driver, header_dynamic_controls_page);
    }

    @Step("Validate the Dynamic Controls Page Header is Present")
    public void validate_dynamic_controls_page_header() {
        verify_text_present(driver, header_dynamic_controls_page,header_dynamic_controls_page_text, "Dynamic Controls Page Header Is Not Matched.");
    }

    @Step("Click Remove Button for Checkbox")
    public void click_remove_button_for_checkbox() {
        verify_element_is_present(driver, button_remove);
        click_element(driver, button_remove);
    }

    @Step("Verify Checkbox is Removed")
    public void verify_checkbox_is_removed() {
        wait_for_element_present(driver, button_add);
        verify_element_is_present(driver, checkbox_remove_text);
        verify_element_is_not_present(driver, button_remove);
    }

    @Step("Click Add Button for Checkbox")
    public void click_add_button_for_checkbox() {
        verify_element_is_present(driver, button_add);
        click_element(driver, button_add);
    }

    @Step("Verify Checkbox is Present")
    public void verify_checkbox_is_present() {
        wait_for_element_present(driver, checkbox);
        verify_element_is_present(driver, button_remove);
        verify_element_is_present(driver, checkbox_reappear_text);
    }

    @Step("Click Enable Button for Text Box")
    public void click_enable_button_for_text_box() {
        verify_element_is_present(driver, button_enable);
        click_element(driver, button_enable);
    }

    @Step("Verify Text Box is Present")
    public void verify_text_box_is_present() {
        wait_for_element_present(driver, button_enable_text);
        verify_element_is_present(driver, input_enable);
        click_element(driver, input_enable);
    }

    @Step("Click Disable Button for Text Box")
    public void click_disable_button_for_text_box() {
        verify_element_is_present(driver, button_disable);
        click_element(driver, button_disable);
    }

    @Step("Verify Text Box is Not Present")
    public void verify_text_box_is_not_present() {
        wait_for_element_present(driver, button_enable);
        verify_element_is_not_present(driver, button_disable);
        verify_element_is_present(driver, button_disable_text);
    }
}