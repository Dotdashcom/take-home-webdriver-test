package dot.dash.step_definitions;

import dot.dash.pages.DyLoader;
import dot.dash.utilities.WaitFor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DyLoader_steps {

    DyLoader dl = new DyLoader();
    @When("user clicks on start button")
    public void user_clicks_on_start_button() {
        dl.startBtn.click();
        WaitFor.invisibilityOf(dl.loadBar);
    }
    @Then("user must see {string} on the screen")
    public void user_must_see_on_the_screen(String string) {
        Assert.assertTrue(dl.helloWorld.isDisplayed());
    }
}
