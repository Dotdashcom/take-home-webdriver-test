package Take_Home_Webdriver_Tasks.step_definitions;

import Take_Home_Webdriver_Tasks.pages.JSAlertPage;
import Take_Home_Webdriver_Tasks.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class T15_StepDef {

    JSAlertPage alertPage = new JSAlertPage();
    Alert alert;
    String actualResultText;
    String expectedResultText;

    @When("user clicks on JS Alert Button")
    public void user_clicks_on_js_alert_button() {

        alertPage.jsAlertBtn.click();
        alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }
    @Then("verify alert message")
    public void verify_alert_message() {

        Assert.assertTrue("Result text did not displayed!",alertPage.resultTxt.isDisplayed());

        actualResultText = alertPage.resultTxt.getText();
        expectedResultText ="You successfully clicked an alert";
        Assert.assertEquals(expectedResultText ,actualResultText);
    }
    @When("user clicks JS confirm Button")
    public void user_clicks_js_confirm_button() {
        alertPage.jsConfirmBtn.click();

    }
    @When("clicks ok on alert")
    public void clicks_ok_on_alert() {
        alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }
    @Then("verify the alert message")
    public void verify_the_alert_message() {

        actualResultText = alertPage.resultTxt.getText();
        expectedResultText = "You clicked: Ok";
        Assert.assertEquals(expectedResultText,actualResultText);
    }
    @When("user clicks on JS Prompt Button")
    public void user_clicks_on_js_prompt_button() {

        alertPage.jsPromptBtn.click();

    }
    @When("types a message on Prompt")
    public void types_a_message_on_prompt() {

        alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys("Hello");
        alert.accept();
    }
    @Then("verify alert message contains the typed message")
    public void verify_alert_message_contains_the_typed_message() {

        actualResultText = alertPage.resultTxt.getText();
        expectedResultText = "You entered: Hello";
        Assert.assertEquals(expectedResultText,actualResultText);
    }

}
