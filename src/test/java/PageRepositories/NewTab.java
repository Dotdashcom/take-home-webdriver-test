package PageRepositories;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NewTab extends PageUtils {

    public WebDriver driver;

    //Constructor
    public NewTab(WebDriver driver) {
        this.driver = driver;
    }

    //***************************
    //**********New Tab**********
    //***************************
    //
    //******New Tab Elements*****

    String windows_new_tab_url_path = "/windows";
    String header_windows_new_tab_page = "//h3";
    String header_windows_new_tab_page_text = "Opening a new window";
    String click_new_tab = "//a[contains(@href,'new')]";
    String header_new_tab = "//h3[contains(text(),'New Window')]";

    //*****New Tab Page Methods****
    @Step("Navigate to Windows New Tab Page")
    public void navigate_to_windows_new_tab_page(String base_url) {
        driver.get(base_url + windows_new_tab_url_path);
        verify_element_is_present(driver, header_windows_new_tab_page);
    }

    @Step("Validate the Windows New Tab Page Header is Present")
    public void validate_windows_new_tab_page_header() {
        verify_text_present(driver, header_windows_new_tab_page,header_windows_new_tab_page_text, "Windows New Tab Page Header Is Not Matched.");
    }

    @Step("Click New Tab Link")
    public void click_new_tab_link() {
        click_element(driver, click_new_tab);
    }

    @Step("Switch to New Tab")
    public void switch_to_new_tab() {
        switch_tab(driver,1);
    }

    @Step("Validate The Header of the Newly Opened Tab - New Window")
    public void validate_newly_open_tab_header() {
        verify_element_is_present(driver, header_new_tab);
    }
}