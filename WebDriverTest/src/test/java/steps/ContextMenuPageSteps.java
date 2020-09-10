package steps;

import base.Functions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPageSteps extends Functions {

    @When("user performs right click on the box")
    public void user_performs_right_click_on_the_box() {

        // context click on box
        contextClick(contextMenu.box);

    }

    @Then("Javascript alert is triggered and text {string} is displayed")
    public void javascript_alert_is_triggered_and_text_is_displayed(String alertMessage) {

        Assert.assertEquals("Message doesn't match", alertMessage, getAlertMessage());
        acceptAlert();
        click(contextMenu.box);

    }
}
