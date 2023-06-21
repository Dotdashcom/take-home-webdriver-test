package StepDefinitions.notificationMessage;

import com.example.navigation.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class NotificationMessageSteps {

    WebDriver driver;
    private final PageObject pageObject;

    public NotificationMessageSteps() {
        driver = WebDriverManager.getDriver();
        this.pageObject = new PageObject(driver);
    }

    @When("the user clicks on the Notification Message page")
    public void the_user_clicks_on_the_notification_message_page() {
        pageObject.notificationMessagePage().the_user_clicks_on_the_notification_message_page();
    }
    @Then("the user should see the Notification Message page")
    public void the_user_should_see_the_notification_message_page() {
        pageObject.notificationMessagePage().the_user_should_see_the_notification_message_page();
    }

    @Then("the user clicks on the {string} link to see {string} notification on the Notification Message page")
    public void theUserClicksOnTheLinkToSeeNotificationOnTheNotificationMessagePage(String clickHereLink, String msg) {
        pageObject.notificationMessagePage().theUserClicksOnTheLinkToSeeNotificationOnTheNotificationMessagePage(clickHereLink,msg);
    }
}
