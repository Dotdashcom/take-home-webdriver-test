package com.theInternet.StepDefinitions;

import com.theInternet.Pages.contextMenuPage;
import com.theInternet.Utilities.BrowserUtils;
import com.theInternet.Utilities.ConfigurationReader;
import com.theInternet.Utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class contextMenuStepDefs4 {
    WebDriver driver;
    Actions actions;
    Alert alert;
    contextMenuPage contextMenuPage = new contextMenuPage();
    @Given("User on Context Menu page")
    public void user_on_Context_Menu_page() {
        System.out.println("Opening the Context Menu page");
        Driver.get().get(ConfigurationReader.get("baseURL")+"context_menu");
        Driver.get().manage().window().fullscreen();
        assertThat("Context Menu", is(contextMenuPage.contextMenuHeader.getText()));

    }

    @When("User Right-click in the box")
    public void user_Right_click_in_the_box() {
        BrowserUtils.waitForPageToLoad(2);
        BrowserUtils.scrollTo(contextMenuPage.box);
        actions = new Actions(Driver.get());
        actions.contextClick(contextMenuPage.box).build().perform();
    }

    @Then("asserts the alert message")
    public void asserts_the_alert_message () {
        String expMessage = "You selected a context menu";
        alert = Driver.get().switchTo().alert();
        String actualMessage = alert.getText();
        alert.accept();
        assertThat(actualMessage, equalTo(expMessage));
    }
}
