package Take_Home_Webdriver_Tasks.step_definitions;

import Take_Home_Webdriver_Tasks.pages.WindowPage;
import Take_Home_Webdriver_Tasks.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Set;

public class T17_StepDef {
    WindowPage windowPage = new WindowPage();

    @When("user clicks on the Click Here link")
    public void user_clicks_on_the_click_here_link() {
        windowPage.clickHereBtn.click();
    }
    @Then("verify that a new tab is opened with text New Window")
    public void verify_that_a_new_tab_is_opened_with_text_new_window() {

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        for (String each : allWindowHandles) {
            Driver.getDriver().switchTo().window(each);
            if(Driver.getDriver().getTitle().equals("New Window")){
                break;
            }
        }

        String expectTitleAfterClicking = "New Window";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectTitleAfterClicking,actualTitle);

    }



}
