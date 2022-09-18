package Take_Home_Webdriver_Tasks.step_definitions;

import Take_Home_Webdriver_Tasks.pages.DynamicPage;
import Take_Home_Webdriver_Tasks.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class T7_StepDef {

    DynamicPage dynamicPage = new DynamicPage();

    String contTextFirstRun;
    String contTextSecondRun;
    String contTextThirdRun;
    @When("user refresh the page")
    public void user_refresh_the_page() {
        contTextFirstRun = dynamicPage.dynContText.getText();

        Driver.getDriver().navigate().refresh();
        contTextSecondRun = dynamicPage.dynContText.getText();

        Driver.getDriver().navigate().refresh();
        contTextThirdRun = dynamicPage.dynContText.getText();


    }
    @Then("verify that the content changes on each refresh")
    public void verify_that_the_content_changes_on_each_refresh() {
        Assert.assertNotEquals(contTextFirstRun, contTextSecondRun);
        Assert.assertNotEquals(contTextSecondRun, contTextThirdRun);
        Assert.assertNotEquals(contTextFirstRun, contTextThirdRun);
    }
}
