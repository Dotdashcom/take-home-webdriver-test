package resources.stepDefinitions;

import resources.utilities.BaseClass;
import resources.pages.NotificationMessagePages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NotificationMessageStep extends BaseClass {

    @Given("User launches the notification message page")
    public void userLaunchesTheNotifictionmsg() {
        BaseClass tb= new BaseClass();
        //  tb.setup();
        String addPath="notification_message_rendered";
        tb.setupDownload(addPath);
    }
    @When("User clicks on clickhere for Notification Message")
    public void clickHereNoti() {
        NotificationMessagePages notimsg= new NotificationMessagePages();
        notimsg.userClickHere();
    }

    @Then("User validates whether the notification message is expected")
    public void checkNotificationMsg() {
        NotificationMessagePages notimsg= new NotificationMessagePages();
        notimsg.checkForNotificationMsg();
    }

}
