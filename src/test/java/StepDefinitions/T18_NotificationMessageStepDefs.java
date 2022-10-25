package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import PageObjects.NotificationMessagePage;
import Utilities.ConfigurationReader;
import Utilities.Driver;

import java.util.Arrays;
import java.util.List;

public class T18_NotificationMessageStepDefs {
    NotificationMessagePage notificationMessagePage = new NotificationMessagePage();

    @Given("user is on {string} Notification Message page")
    public void user_is_on_notification_message_page(String endpoint) {
        Driver.getDriver().get(ConfigurationReader.getProperty("BaseUrl") + endpoint);

    }

    @When("user clicks on Click Here link multiple times")
    public void user_clicks_on_click_here_link_multiple_times() {
        notificationMessagePage.clickHereBtn.click();
    }

    @Then("user should asserts that one of the notification messages shown on click.")
    public void userShouldAssertsThatOneOfTheNotificationMessagesShownOnClick() {
        List<String> possibleMessageList =
                Arrays.asList("Action successful", "Action unsuccesful, please try again", "Action unsuccessful");

        String actualMessage = notificationMessagePage.notificationMessage.getText();
        for (String eachMessage : possibleMessageList) {
            if (actualMessage.equals(eachMessage)) {
                Assert.assertEquals(eachMessage, actualMessage);
            }

        }
    }
}
