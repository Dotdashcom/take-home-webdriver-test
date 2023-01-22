package ui_automation.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_automation.pages.DynamicControlsPage;
import ui_automation.pages.DynamicPageLoadPage;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class DyanamicPageLoad {

    WebDriver driver = Driver.getDriver();

   DynamicPageLoadPage page = new DynamicPageLoadPage(driver);

    @Given("User should be able to navigate to the DynamicPage URL")
    public void user_should_be_able_to_navigate_to_the_DynamicPage_URL() {
        String dynamicPageLoadURL = (ConfigurationReder.getProperties("ui-config.properties", "dynamicPageLoadURL"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(dynamicPageLoadURL);

    }

    @Then("user should be able to click on Start Button and verify message {string}")
    public void user_should_be_able_to_click_on_Start_Button_and_verify_message(String expectedMessage) {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(page.startBtn)).click();
        String actualMessage = page.actualMsg.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Then("user close the driver")
    public void user_close_the_driver()
    {
    Driver.closeDriver();
    }

}
