package PageRepositories;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class Iframe extends PageUtils {

    public WebDriver driver;

    //Constructor
    public Iframe(WebDriver driver) {
        this.driver = driver;
    }

    //**************************
    //**********Iframe**********
    //**************************
    //
    //******Iframe Elements*****

    String iframe_url_path = "/iframe";
    String header_iframe_page = "//h3";
    String header_iframe_page_text = "An iFrame containing the TinyMCE WYSIWYG Editor";
    String iframe_id = "mce_0_ifr";
    String iframe_text_area = "//body[contains(@id,'tinymce')]";
    String text_to_write = "This is a test";


    //*****Iframe Page Methods****
    @Step("Navigate to Iframe Page")
    public void navigate_to_iframe_page(String base_url) {
        driver.get(base_url + iframe_url_path);
        wait_for_element_present(driver, header_iframe_page);
    }

    @Step("Validate the Iframe Page Header is Present")
    public void validate_iframe_page_header() {
        verify_text_present(driver, header_iframe_page,header_iframe_page_text, "Iframe Page Header Is Not Matched.");
    }

    @Step("Switch to IFrame")
    public void switch_to_iframe() {
        switch_iframe(driver, iframe_id);
    }

    @Step("Type in IFrame Text Area")
    public void type_in_iframe_text_area() {
        type_in_field(driver, iframe_text_area,text_to_write);
        custom_wait(1000);
    }

    @Step("Verify the IFrame Text")
    public void verify_iframe_text() {
        verify_text_present(driver,iframe_text_area,text_to_write,text_to_write + " is Not Present in the Text Area.");
    }
}