package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC_18_NotificationMessage_Page;

import java.util.ArrayList;
import java.util.List;

public class TC_18_NotificationMessage_StepDefinitions {
    TC_18_NotificationMessage_Page notificationMessagePage=new TC_18_NotificationMessage_Page();
    @Given("User goes to  the Notification Message Page")
    public void user_goes_to_the_notification_message_page() {

        notificationMessagePage.notificationMsgLink.click();
    }
    @When("User clicks on the Click Here link a multiple times")
    public void user_clicks_on_the_click_here_link_a_multiple_times() {
        List<String> messages=new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            notificationMessagePage.clickHereButton.click();
            messages.add(notificationMessagePage.messages.getText());
        }
        Assert.assertTrue(messages.contains(notificationMessagePage.messages.getText()));
    }

}
