package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.IFramePage;
import utils.PropertyKeys;

import java.time.Duration;

public class IFrameSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private IFramePage iFramePage;
    private String iFrameExpectedText = "this is a test";

    public IFrameSteps() {
        String timeout = PropertyKeys.getProperty("timeout");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
        iFramePage = new IFramePage(driver, wait);
    }

    @Given("user navigates to iframe page")
    public void navigateToIFramePage() {
        driver.get(PropertyKeys.getProperty("baseurl") + "/iframe");
        iFramePage.WaitUntilElementVisible(iFramePage.iFramePageHeader);
    }

    @When("user inputs some text in iframe content body")
    public void inputTextInIFrame() {
        driver.switchTo().frame("mce_0_ifr");
        iFramePage.iFrameContentBody.clear();
        iFramePage.iFrameContentBody.sendKeys("this is a test");
    }

    @Then("iframe content body contains expected text")
    public void validateIFrame() {
        String iFrameActualText = iFramePage.iFrameContentBody.getText();
        Assert.assertEquals(iFrameExpectedText, iFrameActualText);
    }
}
