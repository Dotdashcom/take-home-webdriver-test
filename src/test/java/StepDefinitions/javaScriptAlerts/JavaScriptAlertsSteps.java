package StepDefinitions.javaScriptAlerts;

import com.example.navigation.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsSteps {
    WebDriver driver;
    private final PageObject pageObject;

    public JavaScriptAlertsSteps() {
        driver = WebDriverManager.getDriver();
        this.pageObject = new PageObject(driver);
    }

    @When("the user clicks on the JavaScript Alerts page")
    public void the_user_clicks_on_the_java_script_alerts_page() {
        pageObject.javaScriptAlertsPage().the_user_clicks_on_the_java_script_alerts_page();
    }
    @Then("the user should see the JavaScript Alerts page")
    public void the_user_should_see_the_java_script_alerts_page() {
        pageObject.javaScriptAlertsPage().the_user_should_see_the_java_script_alerts_page();
    }
    @When("the user clicks on the {string} on the JavaScript Alerts page")
    public void the_user_clicks_on_the_on_the_java_script_alerts_page(String jsButton) {
        pageObject.javaScriptAlertsPage().the_user_clicks_on_the_on_the_java_script_alerts_page(jsButton);
    }
    @Then("the user should see the alert message {string} on the JavaScript Alerts page")
    public void the_user_should_see_the_alert_message_on_the_java_script_alerts_page(String jsAlertMessage) {
        pageObject.javaScriptAlertsPage().the_user_should_see_the_alert_message_on_the_java_script_alerts_page(jsAlertMessage);
    }

    @Then("the user should see event confirmation message {string} on the JavaScript Alerts page")
    public void theUserShouldSeeEventConfirmationMessageOnTheJavaScriptAlertsPage(String confirmMsg) {
        pageObject.javaScriptAlertsPage().theUserShouldSeeEventConfirmationMessageOnTheJavaScriptAlertsPage(confirmMsg);
    }

    @When("the user enters {string} on the JavaScript prompt on the JavaScript Alerts page")
    public void theUserEntersOnTheJavaScriptPromptOnTheJavaScriptAlertsPage(String testMsg) {
        pageObject.javaScriptAlertsPage().theUserEntersOnTheJavaScriptPromptOnTheJavaScriptAlertsPage(testMsg);
    }
}
