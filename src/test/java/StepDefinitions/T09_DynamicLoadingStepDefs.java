package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.DynamicLoadingPage;
import Utilities.ConfigurationReader;
import Utilities.Driver;

public class T09_DynamicLoadingStepDefs {

    DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();

    @Given("user is on the {string} Dynamic Loading page")
    public void user_is_on_the_dynamic_loading_page(String endpoint) {
        Driver.getDriver().get(ConfigurationReader.getProperty("BaseUrl") + endpoint);

    }

    @When("user clicks on START button")
    public void user_clicks_on_start_button() {
        dynamicLoadingPage.startBtn.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoadingPage.loadingBar));
    }

    @Then("user verifies that {string} text is displayed")
    public void user_verifies_that_text_is_displayed(String message) {
        Assert.assertEquals(message, dynamicLoadingPage.messageText.getText());
        System.out.println(dynamicLoadingPage.messageText.getText());
    }

}
