package com.theInternet.StepDefinitions;

import com.theInternet.Pages.newTabPage;
import com.theInternet.Utilities.ConfigurationReader;
import com.theInternet.Utilities.Driver;
import io.cucumber.java.en.*;

import java.util.Set;

public class newTabStepDefs {

    newTabPage newTabPage = new newTabPage();

    @Given("User on New Tab")
    public void user_on_New_Tab() {
        System.out.println("Opening a window");
        Driver.get().get(ConfigurationReader.get("baseURL") + "windows");
        Driver.get().manage().window().fullscreen();
    }

    @When("User clicks on the Click Here link")
    public void user_clicks_on_the_Click_Here_link() {
        newTabPage.clickHerebttn.click();
    }

    @Then("assert that a new tab is opened with text {string}")
    public void assert_that_a_new_tab_is_opened_with_text(String string) {
        Set<String> windowHandles = Driver.get().getWindowHandles();
        for (String windowHandle : windowHandles){
            Driver.get().switchTo().window(windowHandle);
            if (Driver.get().getTitle().equals(string));{
                break;
            }
        }
    }
}
