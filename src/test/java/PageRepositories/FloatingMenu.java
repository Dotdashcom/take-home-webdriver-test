package PageRepositories;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class FloatingMenu extends PageUtils {

    public WebDriver driver;

    //Constructor
    public FloatingMenu(WebDriver driver) {
        this.driver = driver;
    }

    //********************************
    //**********Floating Menu*******
    //********************************
    //
    //******Floating Menu Elements*****

    String floating_menu_url_path = "/floating_menu";
    String header_floating_menu_page = "//h3";
    String header_floating_menu_page_text = "Floating Menu";
    String home_link = "//a[contains(text(),'Home')]";
    String news_link = "//a[contains(text(),'News')]";
    String contact_link = "//a[contains(text(),'Contact')]";
    String about_link = "//a[contains(text(),'About')]";


    //*****Floating Menu Page Methods****
    @Step("Navigate to Floating Menu Page")
    public void navigate_to_floating_menu_page(String base_url) {
        driver.get(base_url + floating_menu_url_path);
        wait_for_element_present(driver, header_floating_menu_page);
    }

    @Step("Validate the Floating Menu Page Header is Present")
    public void validate_floating_menu_page_header() {
        verify_text_present(driver, header_floating_menu_page,header_floating_menu_page_text, "Floating Menu Page Header Is Not Matched.");
    }

    @Step ("Scroll Down {0} Pixes")
    public void scroll_down_by_pixes(int pixels) {
        scroll_page(driver, pixels);
    }

    @Step("Verify the Floating Menu is Present")
    public void verify_floating_menu_is_present(){
        wait_for_element_present(driver, home_link);
        wait_for_element_present(driver, news_link);
        wait_for_element_present(driver, contact_link);
        wait_for_element_present(driver, about_link);
    }
}