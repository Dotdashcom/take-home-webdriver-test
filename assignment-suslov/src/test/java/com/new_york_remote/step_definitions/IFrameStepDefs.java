package com.new_york_remote.step_definitions;

import com.new_york_remote.pages.IFramePage;
import com.new_york_remote.utilities.ConfigReader;
import com.new_york_remote.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class IFrameStepDefs {
IFramePage iframePage=new IFramePage();
    @Given("user is on the iframe page")
    public void user_is_on_the_iframe_page() {
        String url= ConfigReader.getPropertiesValue("baseUrl");
        Driver.getDriver().get(url+"/iframe");
    }




    @When("user type in the iframe text box")
    public void user_type_in_the_iframe_text_box() {
       iframePage.alertXButton.click();
Driver.getDriver().switchTo().frame(iframePage.textBox);
iframePage.yourTextGoesHere.sendKeys(Keys.BACK_SPACE+"Thank You!");
    }
    @Then("the typed text is as expected")
    public void the_typed_text_is_as_expected() {
        String actualText = iframePage.yourTextGoesHere.getText();
        String ExpectedText = "Thank You!Your content goes here.";
        Assert.assertTrue(actualText.equals(ExpectedText));
    }


}
