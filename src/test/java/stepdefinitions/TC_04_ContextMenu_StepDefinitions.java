package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.TC_04_ContextMenu_Page;
import utilities.Driver;

import static utilities.Driver.driver;

public class TC_04_ContextMenu_StepDefinitions {
    TC_04_ContextMenu_Page contextMenu=new TC_04_ContextMenu_Page();

    @When("User goes to the context menu")
    public void user_goes_to_the_context_menu() {
        contextMenu.contextMenuLink.click();
    }
    @When("User does the right clicks in the box")
    public void user_does_the_right_clicks_in_the_box() {
        Actions actions=new Actions(Driver.getDriver());
    actions.contextClick(contextMenu.insideBox).perform();

    }
    @Then("User sees Alert popped up and click")
    public void user_sees_alert_popped_up_and_click() {
        driver.switchTo().alert().accept();
    }
    @Then("The right click page displayed")
    public void the_right_click_page_displayed() {
        Assert.assertTrue(contextMenu.alertMessage.isEnabled());
    //  Note : JavaScript Alert is not displayed-- There is a bug
    }

}
