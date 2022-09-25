package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.DynamicLoadingPage;
import utils.PropertyKeys;

import java.time.Duration;

public class DynamicLoadingSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private DynamicLoadingPage dynamicLoadingPage;

    public DynamicLoadingSteps() {
        String timeout = PropertyKeys.getProperty("timeout");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
        dynamicLoadingPage = new DynamicLoadingPage(driver, wait);
    }

    @Given("user navigates to the dynamic loading page")
    public void navigateToDynamicLoadingPage() {
        driver.get(PropertyKeys.getProperty("baseurl") + "/dynamic_loading/2");
        dynamicLoadingPage.WaitUntilElementVisible(dynamicLoadingPage.dynamicLoadPageHeader);
    }

    @And("user clicks on the start button")
    public void clickStartButton() {
        dynamicLoadingPage.WaitUntilElementVisible(dynamicLoadingPage.startButton);
        dynamicLoadingPage.startButton.click();
    }

    @Then("hello world text is displayed")
    public void validateHelloWorldTextIsDisplayed() {
        dynamicLoadingPage.WaitUntilElementVisible(dynamicLoadingPage.finishText);
        String helloWorldText = dynamicLoadingPage.finishText.getText();
        Assert.assertEquals(PropertyKeys.getProperty("finish.text"), helloWorldText);
    }
}
