package steps;

import base.Functions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DynamicContentPageSteps extends Functions {
    public static String previousText;
    public static String updatedText;

    @When("user refreshes the page")
    public void user_refreshes_the_page() {

        for (int i = 0; i < 10; i++) {
            previousText = waitForVisibility(dynamicContentPage.dynamicText).getText().trim();
            driver.navigate().refresh();
            updatedText = waitForVisibility(dynamicContentPage.dynamicText).getText().trim();
            Assert.assertFalse(previousText.equals(updatedText));
        }


    }

    @Then("user sees content is updated")
    public void user_sees_content_is_updated() {

        Assert.assertFalse(previousText.equals(updatedText));
    }
}
