package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.TC_14_MouseHover_Page;
import utilities.Driver;

import java.util.List;

public class TC_14_MouseHover_StepDefinitions {
    TC_14_MouseHover_Page mouseHoverPage=new TC_14_MouseHover_Page();
    Actions actions = new Actions(Driver.getDriver());
    @Given("User goes to the Mouse Hover page")
    public void user_goes_to_the_mouse_hover_page() {
    mouseHoverPage.hoverlink.click();
    }
    @When("User can does mouse hover on each image")
    public void user_can_does_mouse_hover_on_each_image() {
        List<WebElement> images = mouseHoverPage.images;
        for (WebElement eachImage : images) {
            actions.moveToElement(eachImage).perform();
        }
    }
    @Then("User can see Additional information is displayed for each image.")
    public void userCanSeeAdditionalInformationIsDisplayedForEachImage() {
        System.out.println("hoverPage.texts1.getText() = " + mouseHoverPage.texts3.getText());
        Assert.assertTrue(mouseHoverPage.texts3.getText().equals("name: user3"));
    }

}
