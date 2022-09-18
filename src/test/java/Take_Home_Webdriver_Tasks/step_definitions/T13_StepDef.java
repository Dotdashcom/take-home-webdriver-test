package Take_Home_Webdriver_Tasks.step_definitions;

import Take_Home_Webdriver_Tasks.pages.IframePage;
import Take_Home_Webdriver_Tasks.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class T13_StepDef {

    IframePage iframePage = new IframePage();

    @When("user types on the text box on the page")
    public void user_types_on_the_text_box_on_the_page() {

        //I use frame(id) method with id arg.
        Driver.getDriver().switchTo().frame("mce_0_ifr");
        iframePage.commentBody.clear();
        iframePage.commentBody.sendKeys("Hello World!");

    }
    @Then("verify that the typed text is as expected")
    public void verify_that_the_typed_text_is_as_expected() {

        Assert.assertEquals(iframePage.commentBody.getText(), "Hello World!");

    }
}
