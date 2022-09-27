package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ContextMenuPage;
import utils.PropertyKeys;
import java.time.Duration;

public class ContextMenuSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private ContextMenuPage contextMenuPage;

    public ContextMenuSteps() {
        String timeout = PropertyKeys.getProperty("timeout");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
        contextMenuPage = new ContextMenuPage(driver, wait);
    }

    @Given("user navigates to context menu page")
    public void userNavigatesToContextMenuPage() {
        driver.get(PropertyKeys.getProperty("baseurl") + "/context_menu");
        contextMenuPage.WaitUntilElementVisible(contextMenuPage.contextMenuPageHeader);
    }

    @When("user right clicks on context box")
    public void userRightClicksContextBox() {
        contextMenuPage.WaitUntilElementVisible(contextMenuPage.contextBox);
        Actions actions = new Actions(driver);
        actions.contextClick(contextMenuPage.contextBox).perform();
    }

    @Then("context menu alert box is displayed")
    public void contextMenuAlertDisplayed() {
        Alert alert = driver.switchTo().alert();
        Assert.assertNotNull(alert);
    }

    @And("context menu text is displayed")
    public void contextMenuTextDisplayed() {
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(PropertyKeys.getProperty("context.menu.text"), alertText);
    }
}
