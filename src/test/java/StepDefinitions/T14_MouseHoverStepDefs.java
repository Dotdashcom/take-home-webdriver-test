package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import PageObjects.MouseHoverPage;
import Utilities.ConfigurationReader;
import Utilities.Driver;

public class T14_MouseHoverStepDefs {

    MouseHoverPage mouseHoverPage = new MouseHoverPage();
    Actions actions;

    @Given("user is on {string} Mouse Hover page")
    public void user_is_on_mouse_hover_page(String endpoint) {
        Driver.getDriver().get(ConfigurationReader.getProperty("BaseUrl") + endpoint);
    }

    @When("user hover overs each image")
    public void user_hover_overs_each_image() {
        actions = new Actions(Driver.getDriver());
    }

    @Then("user should be able to see additional information about each image")
    public void user_should_be_able_to_see_additional_information_about_each_image() {

        int iteration = 1;
        for (WebElement image : mouseHoverPage.allImages) {
            actions.moveToElement(image).perform();
            Assert.assertEquals(("name: user" + iteration + "\nView profile"), image.getText());
            iteration++;
            System.out.println(image.getText());
        }
    }


}
