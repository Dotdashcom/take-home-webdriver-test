package com.new_york_remote.step_definitions;

import com.new_york_remote.pages.ContextMenuPage;
import com.new_york_remote.utilities.ConfigReader;
import com.new_york_remote.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextBoxStepDefs {
    ContextMenuPage contextMenuPage = new ContextMenuPage();
    WebDriver driver = Driver.getDriver();

    @Given("user is on the Context Menu page")
    public void user_is_on_the_context_menu_page() {
        String url = ConfigReader.getPropertiesValue("baseUrl");
        Driver.getDriver().get(url + "/context_menu");
    }


    @When("user do the right clicks")
    public void user_do_the_right_clicks() {
        Actions actions = new Actions(Driver.getDriver());

        actions.contextClick(contextMenuPage.contextBox).perform();
    }

    @Then("Alert popped up")
    public void alert_popped_up() {
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();

        String expectedResult = "You selected a context menu";
        Assert.assertEquals(expectedResult, alertMessage);
        alert.sendKeys(String.valueOf(Keys.ENTER));

    }

}
