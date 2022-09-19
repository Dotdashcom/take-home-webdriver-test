package Take_Home_Webdriver_Tasks.step_definitions;

import Take_Home_Webdriver_Tasks.pages.DynamicPage;
import Take_Home_Webdriver_Tasks.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class T9_StepDef {
    DynamicPage dynamicPage = new DynamicPage();

    @When("user clicks on Start Button")
    public void user_clicks_on_start_button() {
        dynamicPage.startBtn.click();
    }
    @Then("verify that “Hello World!” text is displayed")
    public void verify_that_hello_world_text_is_displayed() {
        BrowserUtils.waitForVisibilityOf(dynamicPage.loadedText);
        Assert.assertEquals("Hello World!", dynamicPage.loadedText.getText());

    }
}
