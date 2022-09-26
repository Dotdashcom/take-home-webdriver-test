package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.DynamicControlsPage;
import utils.PropertyKeys;

import java.time.Duration;

public class DynamicControlsSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private DynamicControlsPage dynamicControlsPage;

    public DynamicControlsSteps() {
        String timeout = PropertyKeys.getProperty("timeout");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
        dynamicControlsPage = new DynamicControlsPage(driver, wait);
    }

    @Given("user navigates to dynamic controls page")
    public void navigateToDynamicControlsPage() {
        driver.get(PropertyKeys.getProperty("baseurl") + "/dynamic_controls");
        dynamicControlsPage.WaitUntilElementVisible(dynamicControlsPage.dynamicControlsPageHeader);
    }

    @When("user clicks on remove button")
    public void clickRemoveButton() {
        dynamicControlsPage.WaitUntilElementVisible(dynamicControlsPage.removeButton);
        dynamicControlsPage.removeButton.click();
    }

    @And("user clicks on add button")
    public void clickAddButton() {
        dynamicControlsPage.WaitUntilElementVisible(dynamicControlsPage.addButton);
        dynamicControlsPage.addButton.click();
    }

    @When("user clicks on enable button")
    public void clickEnableButton() {
        dynamicControlsPage.WaitUntilElementVisible(dynamicControlsPage.enableButton);
        dynamicControlsPage.enableButton.click();
    }

    @And("user clicks on disable button")
    public void clickDisableButton() {
        dynamicControlsPage.WaitUntilElementVisible(dynamicControlsPage.disableButton);
        dynamicControlsPage.disableButton.click();
    }

    @Then("checkbox is not present")
    public void validateCheckBoxIsNotPresent() {
        dynamicControlsPage.WaitUntilElementVisible(dynamicControlsPage.addButton);
        boolean isPresent = dynamicControlsPage.isElementPresent(By.id("checkbox"));
        Assert.assertFalse(isPresent);
    }

    @Then("checkbox is present")
    public void validateCheckBoxIsPresent() {
        dynamicControlsPage.WaitUntilElementVisible(dynamicControlsPage.removeButton);
        boolean isPresent = dynamicControlsPage.isElementPresent(By.id("checkbox"));
        Assert.assertTrue(isPresent);
    }

    @Then("text box is enabled")
    public void validateTextBoxEnabled() {
        dynamicControlsPage.WaitUntilElementVisible(dynamicControlsPage.disableButton);
        boolean isEnabled = dynamicControlsPage.inputTextBox.isEnabled();
        Assert.assertTrue(isEnabled);
    }

    @Then("text box is disabled")
    public void validateTextBoxDisabled() {
        dynamicControlsPage.WaitUntilElementVisible(dynamicControlsPage.enableButton);
        boolean isEnabled = dynamicControlsPage.inputTextBox.isEnabled();
        Assert.assertFalse(isEnabled);
    }
}
