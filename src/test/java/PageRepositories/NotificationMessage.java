package PageRepositories;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class NotificationMessage extends PageUtils {

    public WebDriver driver;

    //Constructor
    public NotificationMessage(WebDriver driver) {
        this.driver = driver;
    }

    //*************************************
    //**********Notification Message*******
    //*************************************
    //
    //******Notification Message Elements*****

    String notification_message_url_path = "/notification_message_rendered";
    String header_notification_message_page = "//h3";
    String header_notification_message_page_text = "Notification Message";
    String click_here = "//a[contains(@href,'/notification')]";
    String flash_notice = "//div[@id='flash']";
    String success_message = "Action successful";
    String unsuccess_try_again_message = "Action unsuccesful, please try again";
    String unsuccess_message = "Action Unsuccessful";
    String notification_message = "//div[contains(@id,'flash')]";

    //*****Notification Message Page Methods****
    @Step("Navigate to Notification Message Page")
    public void navigate_to_notification_message_page(String base_url) {
        driver.get(base_url + notification_message_url_path);
        wait_for_element_present(driver, header_notification_message_page);
    }

    @Step("Validate the Notification Message Page Header is Present")
    public void validate_notification_message_page_header() {
        verify_text_present(driver, header_notification_message_page,header_notification_message_page_text, "Notification Message Page Header Is Not Matched.");
    }

    @Step("Click for New Message")
    public void click_for_new_message() {
        wait_for_element_present(driver,click_here);
        click_element(driver, click_here);
    }

    @Step("'Action successful' Message is Displayed")
    public void action_successful_is_displayed() {
        Assert.assertTrue(true);
    }

    @Step("'Action Unsuccessful' Message is Displayed")
    public void action_unsuccessful_is_displayed() {
        Assert.assertTrue(true);
    }

    @Step("'Action unsuccesful, please try again' Message is Displayed")
    public void action_unsuccessful_try_again_is_displayed() { Assert.assertTrue(true); }

    @Step("Check the Notice Message")
    public void check_notice_message() {
        boolean isPresent = false;
        if (driver.findElement(By.xpath(notification_message)).getText().contains(success_message)) {
            action_successful_is_displayed();
            isPresent = true;
        }

        if (driver.findElement(By.xpath(notification_message)).getText().trim().contains(unsuccess_message)) {
            action_unsuccessful_is_displayed();
            isPresent = true;
        }

        if (driver.findElement(By.xpath(notification_message)).getText().trim().contains(unsuccess_try_again_message)) {
            action_unsuccessful_try_again_is_displayed();
            isPresent = true;
        }

        if (!isPresent) { Assert.assertTrue(false, success_message + " ," + unsuccess_message + " ," + unsuccess_try_again_message + " Message is Not Shown for Notifications");}
    }
}