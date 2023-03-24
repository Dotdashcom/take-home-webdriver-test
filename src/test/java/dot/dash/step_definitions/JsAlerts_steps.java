package dot.dash.step_definitions;

import dot.dash.pages.JsAlerts;
import dot.dash.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

public class JsAlerts_steps {

    String message = "";
    JsAlerts jsa = new JsAlerts();

    @When("user {string} Button")
    public void user_button(String button) {
        jsa.buttons(button).click();
    }

    @Then("verify alert message {string}")
    public void verify_alert_message(String msg) {
        Alert alert = Driver.getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(), msg);
        alert.accept();
    }

    @When("user {string} Button and clicks ok on alert")
    public void user_button_and_clicks_ok_on_alert(String button) {
        jsa.buttons(button).click();
    }

    @When("user {string} Button and types {string} on Prompt")
    public void user_button_and_types_on_prompt(String button, String msg) {
        message = msg;
        WebElement buttonEl = jsa.buttons(button);
        buttonEl.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys(message);
        alert.accept();
    }

    @Then("verify that the alert message contains the typed message")
    public void verify_that_the_alert_message_contains_the_typed_message() {
        String resText = jsa.result.getText();
        String actualMsg = resText.substring(resText.indexOf(":")+2);
        Assert.assertEquals(actualMsg, message);
    }
}
