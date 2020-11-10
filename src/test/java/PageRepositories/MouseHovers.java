package PageRepositories;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class MouseHovers extends PageUtils {

    public WebDriver driver;

    //Constructor
    public MouseHovers(WebDriver driver) {
        this.driver = driver;
    }

    //********************************
    //**********Mouse Hovers*******
    //********************************
    //
    //******Mouse Hovers Elements*****

    String mouse_hovers_url_path = "/hovers";
    String header_mouse_hovers_page = "//h3";
    String header_mouse_hovers_page_text = "Hovers";
    String view_profile = "//a[contains(@href,'users/regex')]";
    String view_profile_image = "//a[contains(@href,'users/regex')]/../..";

    //*****Mouse Hovers Page Methods****
    @Step("Navigate to Mouse Hovers Page")
    public void navigate_to_mouse_hovers_page(String base_url) {
        driver.get(base_url + mouse_hovers_url_path);
        wait_for_element_present(driver, header_mouse_hovers_page);
    }

    @Step("Validate the Mouse Hovers Page Header is Present")
    public void validate_mouse_hovers_page_header() {
        verify_text_present(driver, header_mouse_hovers_page,header_mouse_hovers_page_text, "Mouse Hovers Page Header Is Not Matched.");
    }

    @Step ("Validate Information is Displayed with Mouse Hover Image - {0}")
    public void validate_information_is_displayed(String image_on) {
        wait_for_element_present(driver, view_profile.replaceAll("regex", image_on));
    }

    @Step ("Validate Information is Not Displayed with Mouse Hover Image - {0}")
    public void validate_information_is_not_displayed(String image_on) {
        Assert.assertFalse(driver.findElement(By.xpath(view_profile.replaceAll("regex", image_on))).isDisplayed(), "The Information for Image" + image_on + " is Displayed");
    }

    @Step ("Mouse Hover to the Image - {0}")
    public void mouse_hover_to_image(String image_no) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(view_profile_image.replaceAll("regex", image_no)))).build().perform();
        custom_wait(500);
    }
}