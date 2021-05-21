package com.interview.step_definitions;

import com.interview.pages.ContextMenuPage;
import com.interview.utilities.ConfigurationReader;
import com.interview.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;

public class contextBox_stepDefinition {
ContextMenuPage contextMenuPage=new ContextMenuPage();
    @Given("user is on the Context Menu page")
    public void user_is_on_the_context_menu_page() {
        String url= ConfigurationReader.getProperty("baseUrl");
        Driver.getDriver().get(url+"/context_menu");
    }




    @When("user do the right clicks")
    public void user_do_the_right_clicks() {
        Actions actions = new Actions(Driver.getDriver());

        actions.contextClick(contextMenuPage.contextBox).perform();
    }
    @Then("Alert popped up")
    public void alert_popped_up() {
        Alert alert =Driver.getDriver().switchTo().alert();
         alert.accept();
      //   String actualText =contextMenuPage.alertMessage.getCssValue("script");
      //  System.out.println("actualText = " + actualText);


         Assert.assertTrue(contextMenuPage.alertMessage.isEnabled());

    }

}
