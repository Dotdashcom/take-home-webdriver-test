package PageRepositories;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ContextMenu extends PageUtils {

    public WebDriver driver;

    //Constructor
    public ContextMenu(WebDriver driver) {
        this.driver = driver;
    }

    //********************************
    //**********Context Menu**********
    //********************************
    //
    //******Context Menu Elements*****

    String context_menu_url_path = "/context_menu";
    String header_context_menu_page = "//h3";
    String header_context_menu_page_text = "Context Menu";
    String right_select_box = "//div[contains(@id,'hot-spot') and contains(@oncontextmenu, 'displayMessage')]";
    String alert_message_context_menu_page = "You selected a context menu";

    //*****Context Menu Page Methods****
    @Step("Navigate to Context Menu Page")
    public void navigate_to_context_menu_page(String base_url) {
        driver.get(base_url + context_menu_url_path);
        wait_for_element_present(driver, header_context_menu_page);
    }

    @Step("Validate the Context Menu Page Header is Present")
    public void validate_context_menu_page_header() {
        verify_text_present(driver, header_context_menu_page,header_context_menu_page_text, "Context Menu Page Header Is Not Matched.");
    }

    @Step("Right Click the Box in Context Menu Page")
    public void right_click_box_in_context_menu_page() {
        verify_element_is_present(driver,right_select_box);
        right_click_context_menu(driver, right_select_box);
    }

    @Step("Verify the Alert Message in Context Menu Page")
    public void verify_alert_message_in_context_menu_page() {
        verify_alert_message(driver, alert_message_context_menu_page);
    }

    @Step("Click OK for the Alert Message in Context Menu Page")
    public void accept_alert_message_in_context_menu_page() {
        accept_alert_message(driver);
    }

}