package steps;

import base.Functions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class IframePageSteps extends Functions {

    @When("User able to enter {string} into the textBox")
    public void user_able_to_enter_into_the_textBox(String text) {

        switchToFrame(iframePage.iFrame);
        enterText(iframePage.textBox, text);


    }

    @Then("User sees {string} entered")
    public void user_sees_entered(String expectedText) {

        String actualText = iframePage.textBox.getText();
        Assert.assertEquals(expectedText, actualText);

    }
}
