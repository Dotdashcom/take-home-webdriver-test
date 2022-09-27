package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.JSAlertPage;
import utils.PropertyKeys;

import java.time.Duration;

public class JSAlertSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private JSAlertPage jsAlertPage;
    String expectedText = "this is test for js prompt alert";

    public JSAlertSteps() {
        String timeout = PropertyKeys.getProperty("timeout");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
        jsAlertPage = new JSAlertPage(driver, wait);
    }

    @Given("user navigates to JS alert page")
    public void navigateToJSAlertPage() {
        driver.get(PropertyKeys.getProperty("baseurl") + "/javascript_alerts");
        jsAlertPage.WaitUntilElementVisible(jsAlertPage.jsAlertPageHeader);
    }

    @When("user clicks on JS alert button")
    public void clickJSAlertButton() {
        jsAlertPage.WaitUntilElementVisible(jsAlertPage.jsAlertButton);
        jsAlertPage.jsAlertButton.click();
    }

    @When("user clicks on JS confirm button")
    public void clickJSConfirmButton() {
        jsAlertPage.WaitUntilElementVisible(jsAlertPage.jsConfirmButton);
        jsAlertPage.jsConfirmButton.click();
    }

    @When("user clicks on JS prompt button")
    public void clickJSPromptButton() {
        jsAlertPage.WaitUntilElementVisible(jsAlertPage.jsPromptButton);
        jsAlertPage.jsPromptButton.click();
    }

    @And("user enters text in JS prompt alert")
    public void inputTextInJSPrompt() {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(expectedText);
        alert.accept();
    }

    @Then("JS alert message is displayed")
    public void validateJSAlertMessageDisplayed() {
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();
    }

    @Then("JS confirm message is displayed")
    public void validateJSConfirmMessageDisplayed() {
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");
        alert.accept();
    }

    @Then("JS prompt alert contains expected text")
    public void validateJSPromptAlert() {
        Assert.assertTrue(jsAlertPage.resultText.getText().contains(expectedText));
    }
}
