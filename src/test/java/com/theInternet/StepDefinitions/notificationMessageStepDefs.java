package com.theInternet.StepDefinitions;

import com.github.javafaker.Faker;
import com.theInternet.Pages.notificationMessagePage;
import com.theInternet.Utilities.ConfigurationReader;
import com.theInternet.Utilities.Driver;
import io.cucumber.java.en.*;

import java.util.Arrays;
import java.util.List;

public class notificationMessageStepDefs {
    notificationMessagePage notificationMessagePage = new notificationMessagePage();
    Faker faker = new Faker();

    @Given("User on Notification Message page")
    public void user_on_Notification_Message_page() {
        System.out.println("Opening a Notification Message page");
        Driver.get().get(ConfigurationReader.get("baseURL")+"notification_message_rendered");
        Driver.get().manage().window().fullscreen();
    }

    @When("User clicks on the Click Here link a multiple times.")
    public void user_clicks_on_the_Click_Here_link_a_multiple_times() {
        int num = faker.number().numberBetween(2, 6);
        for (int i=1; i<num; i++) {
            notificationMessagePage.clickHere.click();
        }
    }

    @Then("assert that one of the {string}, {string} and {string} messages show on click.")
    public void assert_that_one_of_the_and_messages_show_on_click(String string, String string2, String string3) {
        String actual = notificationMessagePage.clickHere.getText();
        List<String> messages = Arrays.asList(string, string2, string3);
        for (String message : messages){
            if(message.contains(actual));
            break;
        }
    }
}
