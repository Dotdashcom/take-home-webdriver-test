package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.TC_13_Iframe_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.Driver.driver;

public class TC_13_Iframe_StepDefinitions {
    TC_13_Iframe_Page iframePage=new TC_13_Iframe_Page();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    @Given("User goes to the iframe page")
    public void user_goes_to_the_iframe_page() {
    iframePage.iframeLink.click();
    }
    @When("User types in the iframe text box")
    public void user_types_in_the_iframe_text_box() {
        iframePage.iframeText.click();
        ReusableMethods.waitForVisibility(iframePage.closeBtn,5);
        js.executeScript("arguments[0].click();", iframePage.closeBtn);
        driver.switchTo().frame(iframePage.iframe);
        iframePage.textBox.clear();
        iframePage.textBox.sendKeys(ConfigReader.getProperty("NewText"));
    }
    @Then("The typed text is as expected")
    public void the_typed_text_is_as_expected() {
        String actualText = iframePage.textBox.getText();
        String ExpectedText = "Knowledge is power.";
        Assert.assertTrue(actualText.equals(ExpectedText));

    }

}
