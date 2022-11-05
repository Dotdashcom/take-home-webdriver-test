package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.TC_12_FloatingMenu_Page;
import utilities.Driver;

public class TC_12_FloatingMenu_StepDefinitions {
    TC_12_FloatingMenu_Page floatingMenuPage=new TC_12_FloatingMenu_Page();
    @Given("User goes to the Floating Menu page")
    public void user_goes_to_the_floating_menu_page() {
    floatingMenuPage.floatingMenuLink.click();
    }
    @When("User scrolls the page")
    public void user_scrolls_the_page() {
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, -500)");
    }
    @Then("The floating menu is still displayed")
    public void the_floating_menu_is_still_displayed() {
        Assert.assertTrue(floatingMenuPage.floatingMenu.isDisplayed());
    }

}
