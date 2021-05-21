package com.interview.step_definitions;

import com.interview.pages.NotificationMessagePage;
import com.interview.utilities.ConfigurationReader;
import com.interview.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class notificationMessage_stepDefinition {
NotificationMessagePage notificationMessagePage=new NotificationMessagePage();
    @Given("user is on the Notification Message Page")
    public void user_is_on_the_notification_message_page() {
        String url= ConfigurationReader.getProperty("baseUrl");
        Driver.getDriver().get(url+"/notification_message_rendered");
    }



    @When("user clicks on the Click Here link a multiple times")
    public void user_clicks_on_the_click_here_link_a_multiple_times() {
        List<String> messages=new ArrayList<>();
        for (int i = 0; i <7 ; i++) {
            notificationMessagePage.clickHereButton.click();
            System.out.println("notificationMessagePage.messages.getText() = " + notificationMessagePage.messages.getText());
            messages.add(notificationMessagePage.messages.getText());
        }
        System.out.println("messages = " + messages);

        Assert.assertTrue(messages.contains(notificationMessagePage.messages.getText()));
    }
    @Then("asserts that one of the “Action Successful”, “Action unsuccessful, please try again”and “Action Unsuccessful” messages show on click")
    public void asserts_that_one_of_the_action_successful_action_unsuccessful_please_try_again_and_action_unsuccessful_messages_show_on_click() {

    }

}
