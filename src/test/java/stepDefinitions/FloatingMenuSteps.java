package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.FloatingMenuPage;
import utils.PropertyKeys;
import java.time.Duration;

public class FloatingMenuSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private FloatingMenuPage floatingMenuPage;

    public FloatingMenuSteps() {
        String timeout = PropertyKeys.getProperty("timeout");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
        floatingMenuPage = new FloatingMenuPage(driver, wait);
    }

    @Given("user navigates to floating menu page")
    public void navigateToFloatingMenuPage() {
        driver.get(PropertyKeys.getProperty("baseurl") + "/floating_menu");
        floatingMenuPage.WaitUntilElementVisible(floatingMenuPage.floatingMenuPageHeader);
    }

    @When("user scrolls down to the bottom of the page")
    public void scrollDownPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Then("floating menu is still visible")
    public void assertFloatingMenuVisible() {
        Assert.assertTrue(floatingMenuPage.menu.isDisplayed());
    }
}
