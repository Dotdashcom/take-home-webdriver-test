package PageRepositories;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DropdownList extends PageUtils {

    public WebDriver driver;

    //Constructor
    public DropdownList(WebDriver driver) {
        this.driver = driver;
    }

    //********************************
    //*******Dropdown List Page*******
    //********************************
    //
    //*******Dropdown List************

    String dropdown_url_path = "/dropdown";
    String header_dropdown_page = "//h3";
    String header_dropdown_page_text = "Dropdown List";
    String select_dropdown_list = "//select[contains(@id,'dropdown')]";
    String option1_text = "Option 1";
    String option2_text = "Option 2";
    String select_option1 = "//option[contains(.,'"+ option1_text +"')]";
    String select_option2 = "//option[contains(.,'"+ option2_text +"')]";;
    String option1_selected = "//option[contains(.,'"+ option1_text + "') and contains(@selected,'selected')]";
    String option2_selected = "//option[contains(.,'"+ option2_text + "') and contains(@selected,'selected')]";


    //*****Dropdown Page Methods****
    @Step("Navigate to Dropdown List Page")
    public void navigate_to_dropdown_list_page(String base_url) {
        driver.get(base_url + dropdown_url_path);
        wait_for_element_present(driver, header_dropdown_page);
    }

    @Step("Validate the Dropdown Page Header is Present")
    public void validate_dropdown_page_header() {
        verify_text_present(driver, header_dropdown_page,header_dropdown_page_text, "Dropdown List Page Header Is Not Matched.");
    }

    @Step ("Select Option 1")
    public void select_option1 () {
        click_element(driver,select_dropdown_list);
        click_element(driver,select_option1);
    }

    @Step ("Select Option 2")
    public void select_option2 () {
        click_element(driver,select_dropdown_list);
        click_element(driver,select_option2);
    }

    @Step ("Verify Option 1 is Selected")
    public void verify_option1_selected () {
        wait_for_element_present(driver,option1_selected);
        verify_element_is_present(driver,option1_selected);
        verify_text_present(driver,option1_selected,option1_text, option2_text + " is Not Selected Properly." );
        custom_wait(1000);
    }

    @Step ("Verify Option 2 is Selected")
    public void verify_option2_selected () {
        wait_for_element_present(driver,option2_selected);
        verify_element_is_present(driver,option2_selected);
        verify_text_present(driver,option2_selected,option2_text, option2_text + " is Not Selected Properly." );
        custom_wait(1000);
    }
}