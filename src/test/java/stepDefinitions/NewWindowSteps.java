package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.NewWindowPage;
import utils.PropertyKeys;
import java.time.Duration;
import java.util.Set;

public class NewWindowSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private NewWindowPage newWindowPage;

    public NewWindowSteps() {
        String timeout = PropertyKeys.getProperty("timeout");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
        newWindowPage = new NewWindowPage(driver, wait);
    }

    @Given("user navigates to new window page")
    public void navigateToNewWindowPage() {
        driver.get(PropertyKeys.getProperty("baseurl") + "/windows");
        newWindowPage.WaitUntilElementVisible(newWindowPage.newWindowPageHeader);
    }

    @When("user clicks on \"Click Here\" link on new window page")
    public void clickLink() {
        newWindowPage.WaitUntilElementVisible(newWindowPage.clickHereLink);
        newWindowPage.clickHereLink.click();
    }

    @Then("new tab is opened with text \"New Window\"")
    public void validateNewWindowOpened() {
        String currentTab = driver.getWindowHandle();
        String currentTabName = driver.getTitle();
        Assert.assertEquals("The Internet", currentTabName);
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        String otherTabName = driver.getTitle();
        Assert.assertEquals("New Window", otherTabName);
    }
}
