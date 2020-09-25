package com.theInternet.StepDefinitions;

import com.theInternet.Pages.iframePage;
import com.theInternet.Utilities.ConfigurationReader;
import com.theInternet.Utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class iframeStepDefs {
    iframePage iframePage = new iframePage();
    WebDriverWait wait;
    String text = "Hey, how are you doing?";

    @Given("User on iFrame page")
    public void user_on_iFrame_page() {
        System.out.println("Opening the iFrame page");
        Driver.get().get(ConfigurationReader.get("baseURL")+"iframe");
        Driver.get().manage().window().fullscreen();
    }

    @When("switches to iFrame and types some text")
    public void switches_to_Iframe_and_types_some_text() {
        wait = new WebDriverWait(Driver.get(), 5);
        Driver.get().switchTo().frame(0);
        iframePage.textField.clear();
        iframePage.iframe.sendKeys(text);
    }

    @Then("the typed text is as expected")
    public void the_typed_text_is_as_expected() {
        String actual = iframePage.iframe.getText();
        assertTrue(actual.equals(text));
    }
}
