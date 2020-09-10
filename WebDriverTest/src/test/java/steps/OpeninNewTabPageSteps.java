package steps;

import base.Functions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class OpeninNewTabPageSteps extends Functions {

    @When("user clicks the link")
    public void user_clicks_the_link() {

        String parentHandle = getParentHandle();
        click(openinNewTabPage.linkToNewWindow);
        switchToChildWindow(parentHandle);
    }

    @Then("user sees {string} sign in newly opened window")
    public void user_sees_sign_in_newly_opened_window(String expectedMessage) {

        Assert.assertEquals(expectedMessage, openinNewTabPage.newWindowMessage.getText());
    }
}
