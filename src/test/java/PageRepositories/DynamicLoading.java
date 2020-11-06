package PageRepositories;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DynamicLoading extends PageUtils {

    public WebDriver driver;

    //Constructor
    public DynamicLoading(WebDriver driver) {
        this.driver = driver;
    }

    //********************************
    //*****Dynamic Loading Menu******
    //********************************
    //
    //****Dynamic Loading Elements***

    String dynamic_loading_url_path = "/dynamic_loading";
    String dynamic_loading_context_path_2 = "/2";
    String header_dynamic_loading_page = "//h3";
    String header_dynamic_loading_page_context_path_2 = "//h4";
    String header_dynamic_loading_page_text = "Dynamically Loaded Page Elements";
    String header_dynamic_loading_page_context_path_2_text = "Example 2: Element rendered after the fact";
    String button_start = "//div[contains(@id,'start')]/button";
    String finish_text = "Hello World!";
    String rendered_finish = "//div[contains(@id,'finish')]/h4";

    //*****Dynamic Loading Page Methods****
    @Step("Navigate to Dynamic Loading Page")
    public void navigate_to_dynamic_loading_page_example2(String base_url) {
        driver.get(base_url + dynamic_loading_url_path + dynamic_loading_context_path_2);
        wait_for_element_present(driver, header_dynamic_loading_page);
    }

    @Step("Validate the Dynamic Loading Page Header is Present")
    public void validate_dynamic_loading_page_header_context_path_2() {
        verify_text_present(driver, header_dynamic_loading_page,header_dynamic_loading_page_text, "Dynamic Loading Page Header Is Not Matched.");
        verify_text_present(driver, header_dynamic_loading_page_context_path_2,header_dynamic_loading_page_context_path_2_text, "Example Header Is Not Matched.");

    }

    @Step("Click Start Button for Rendering")
    public void click_start_button_for_rendering() {
        verify_element_is_present(driver, button_start);
        click_element(driver, button_start);
    }

    @Step("Verify Hello World! is Displayed")
    public void verify_rendered_text_displayed() {
        wait_for_element_present(driver, rendered_finish);
        verify_text_present(driver, rendered_finish, finish_text, "Rendering is Not Completed.");
    }
}