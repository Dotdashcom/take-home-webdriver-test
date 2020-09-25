package com.theInternet.StepDefinitions;
import com.theInternet.Pages.dynamicLoadingPage;
import com.theInternet.Utilities.ConfigurationReader;
import com.theInternet.Utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class dynamicLoadingStepDefs {

    dynamicLoadingPage dynamicLoadingPage = new dynamicLoadingPage();
    WebDriverWait wait;

    @Given("User on Dynamic Loading page")
    public void user_on_Dynamic_Loading_page() {
        System.out.println("Opening the Dynamic Loading page");
        Driver.get().get(ConfigurationReader.get("baseURL") + "dynamic_loading/2");
    }

    @When("clicks the start button and uses explicit wait.")
    public void clicks_the_start_button_and_uses_explicit_wait() {
        dynamicLoadingPage.startButton.click();
        wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadingPage.message));
    }

    @Then("asserts that {string} text is displayed.")
    public void asserts_that_text_is_displayed(String string) {
        assertTrue(dynamicLoadingPage.message.isDisplayed());
    }
}
