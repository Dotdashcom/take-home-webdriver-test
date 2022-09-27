package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.NotificationMessagePage;
import utils.PropertyKeys;

import java.time.Duration;

public class NotificationMessageSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private NotificationMessagePage notificationMessagePage;

    public NotificationMessageSteps() {
        String timeout = PropertyKeys.getProperty("timeout");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
        notificationMessagePage = new NotificationMessagePage(driver, wait);
    }

    @Given("user navigates to notification message page")
    public void navigateToNotificationMessagePage() {
        driver.get(PropertyKeys.getProperty("baseurl") + "/notification_message_rendered");
        notificationMessagePage.WaitUntilElementVisible(notificationMessagePage.notificationMessagePageHeader);
    }

    @When("user clicks on \"Click Here\" link on notification message page")
    public void clickOnLink() {
        notificationMessagePage.WaitUntilElementVisible(notificationMessagePage.clickHereLink);
        notificationMessagePage.clickHereLink.click();
    }

    @Then("notification message is displayed")
    public void validateNotificationMessageDisplayed() {
        notificationMessagePage.WaitUntilElementVisible(notificationMessagePage.flashMessage);
        String flashMessageText = notificationMessagePage.flashMessage.getText();
        System.out.println("FLASH MESSAGE: " + flashMessageText);
        boolean isFlashMessageDisplayed = false;
        if (flashMessageText.equals("Action unsuccesful, please try again\n" + "×") || flashMessageText.equals("Action successful\n" +
                "×")) {
            isFlashMessageDisplayed = true;
        }
        Assert.assertTrue(isFlashMessageDisplayed);
    }
}
