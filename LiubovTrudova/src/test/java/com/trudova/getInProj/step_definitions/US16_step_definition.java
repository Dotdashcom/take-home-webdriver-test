package com.trudova.getInProj.step_definitions;

import com.trudova.getInProj.pages.NewWindowPage;
import com.trudova.getInProj.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Set;

public class US16_step_definition {
private NewWindowPage newWindowPage = new NewWindowPage();
    @Given("navigate to Open in New Tab page")
    public void navigate_to_open_in_new_tab_page() {
     newWindowPage.multipleWindows.click();
    }

    @When("click on click here link")
    public void click_on_click_here_link() {
       newWindowPage.clickHereLink.click();
    }
    @Then("verify new window been open and title contain New Window")
    public void verify_new_window_been_open_and_title_contain_new_window() {
        Set<String> allWindowHandles =Driver.getDriver().getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            Driver.getDriver().switchTo().window(windowHandle);
            if (Driver.getDriver().getTitle().equals("New Window")){
                break;
            }
        }
        Assert.assertTrue(Driver.getDriver().getTitle().equals("New Window"));
    }

}
