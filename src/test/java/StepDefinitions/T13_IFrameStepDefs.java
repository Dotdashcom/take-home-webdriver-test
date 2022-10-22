package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import PageObjects.IFramePage;
import Utilities.ConfigurationReader;
import Utilities.Driver;

public class T13_IFrameStepDefs {

    IFramePage iFramePage = new IFramePage();
    String randomText = "Take Home Assignment!";

    @Given("user is on {string} iframe page")
    public void user_is_on_iframe_page(String endpoint) {
        Driver.getDriver().get(ConfigurationReader.getProperty("BaseUrl") + endpoint);
    }
    @When("user switches to iFrame and types random text")
    public void user_switches_to_i_frame_and_types_random_text() {
        iFramePage.toxBtn.click();
        Driver.getDriver().switchTo().frame("mce_0_ifr");
        iFramePage.contentBody.clear();
        iFramePage.contentBody.sendKeys(randomText);
    }
    @Then("user should be able to assert expected and actual texts")
    public void user_should_be_able_to_assert_expected_and_actual_texts() {
        Assert.assertEquals(randomText, iFramePage.contentBody.getText());
    }


}
