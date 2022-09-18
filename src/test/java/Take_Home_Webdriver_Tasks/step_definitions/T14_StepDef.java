package Take_Home_Webdriver_Tasks.step_definitions;

import Take_Home_Webdriver_Tasks.pages.HoversPage;
import Take_Home_Webdriver_Tasks.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class T14_StepDef {

    HoversPage hoversPage = new HoversPage();

    Actions actions;
    @When("user does a mouse hover on each image")
    public void user_does_a_mouse_hover_on_each_image() {

        actions = new Actions(Driver.getDriver());
    }
    @Then("verify that additional information is displayed for each image")
    public void verify_that_additional_information_is_displayed_for_each_image() {

        int i = 1;
        for(WebElement eachImage : hoversPage.allImages){
            actions.moveToElement(eachImage).perform();
            Assert.assertEquals(("name: user" + i +"\nView profile"), eachImage.getText());
            i++;
        }
    }

}
