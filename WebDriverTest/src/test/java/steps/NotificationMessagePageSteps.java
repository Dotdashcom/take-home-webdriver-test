package steps;

import base.Functions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class NotificationMessagePageSteps extends Functions {

    @When("user clicks the link to load the new message")
    public void user_clicks_the_link_to_load_the_new_message() {
        click(notificationMessagePage.linkToMessage);
    }

    @Then("user sees notification message")
    public void user_sees_notification_message(DataTable dataTable) {

        List<String> expectedMessages = dataTable.asList();
        for (int i = 0; i < 10; i++) {
            String nm = notificationMessagePage.notificationMessage.getText().replace("×","").trim();
            Assert.assertTrue(nm.equals(expectedMessages.get(0)) || nm.equals(expectedMessages.get(1)));
            click(notificationMessagePage.linkToMessage);
        }
    }
}

