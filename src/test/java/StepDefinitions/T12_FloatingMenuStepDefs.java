package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import PageObjects.FloatingMenuPage;
import Utilities.ConfigurationReader;
import Utilities.Driver;

public class T12_FloatingMenuStepDefs {

    FloatingMenuPage floatingMenuPage = new FloatingMenuPage();

    @Given("user is on {string} Floating Menu page")
    public void user_is_on_floating_menu_page(String endpoint) {
        Driver.getDriver().get(ConfigurationReader.getProperty("BaseUrl") + endpoint);

    }

    @When("user scrolls down")
    public void user_scrolls_down() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", floatingMenuPage.pageContent);
    }

    @Then("user should be able to assert that floating menu is still displayed")
    public void user_should_be_able_to_assert_that_floating_menu_is_still_displayed() {
        for (WebElement eachMenuHeader : floatingMenuPage.floatingMenuList) {
            Assert.assertTrue(eachMenuHeader.isDisplayed());
        }
    }


}
