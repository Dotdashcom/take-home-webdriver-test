package steps;

import base.Functions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DynamicControlsPageElements extends Functions {

    @When("user clicks Remove button")
    public void user_clicks_Remove_button() {

        click(dynamicControlsPage.removeAddBtn);
    }

    @Then("user sees {string} and checkbox is removed")
    public void user_sees_and_checkbox_is_removed(String expectedMessage) {

        String actualMessage = waitForVisibility(dynamicControlsPage.checkboxMessage).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("user clicks Add button and check the checkbox")
    public void user_clicks_Add_button_and_check_the_checkbox() {

        click(dynamicControlsPage.removeAddBtn);
        click(dynamicControlsPage.checkbox);
    }

    @Then("users sees checkbox checked")
    public void users_sees_checkbox_checked() {

        Assert.assertTrue(dynamicControlsPage.checkbox.isSelected());
    }

    @When("users clicks on Enable button and send text {string} to the text box")
    public void users_clicks_on_Enable_button_and_send_text_to_the_text_box(String textToSend) {

        click(dynamicControlsPage.enableDisableBtn);
        enterText(dynamicControlsPage.textBox, textToSend);
    }

    @Then("users sees {string} and text into the text {string} box")
    public void users_sees_and_text_into_the_text_box(String expectedMessage, String expectedText) {

        Assert.assertEquals(expectedMessage, dynamicControlsPage.textBoxMessage.getText());
        Assert.assertEquals(expectedText, dynamicControlsPage.textBox.getAttribute("value"));
    }


}
