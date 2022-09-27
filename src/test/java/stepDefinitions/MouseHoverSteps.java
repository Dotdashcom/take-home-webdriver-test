package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.MouseHoverPage;
import utils.PropertyKeys;
import java.time.Duration;

public class MouseHoverSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private MouseHoverPage mouseHoverPage;

    public MouseHoverSteps() {
        String timeout = PropertyKeys.getProperty("timeout");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
        mouseHoverPage = new MouseHoverPage(driver, wait);
    }

    @Given("user navigates to mouse hover page")
    public void navigateToMouseHoverPage() {
        driver.get(PropertyKeys.getProperty("baseurl") + "/hovers");
        mouseHoverPage.WaitUntilElementVisible(mouseHoverPage.hoversPageHeader);
    }

    @When("^user hovers mouse cursor over user \"(.*)\" image$")
    public void hoverMouseOverUser(int user) {
        Actions actions = new Actions(driver);
        switch (user) {
            case 1:
                actions.moveToElement(mouseHoverPage.userOneImage).perform();
                break;
            case 2:
                actions.moveToElement(mouseHoverPage.userTwoImage).perform();
                break;
            case 3:
                actions.moveToElement(mouseHoverPage.userThreeImage).perform();
                break;
            default:
                System.out.println("Invalid User");
        }
    }

    @Then("^user \"(.*)\" caption is displayed$")
    public void validateUserCaptionDisplayed(int user) {
        Actions actions = new Actions(driver);
        switch (user) {
            case 1:
                Assert.assertTrue(mouseHoverPage.userOneCaption.isDisplayed());
                break;
            case 2:
                Assert.assertTrue(mouseHoverPage.userTwoCaption.isDisplayed());
                break;
            case 3:
                Assert.assertTrue(mouseHoverPage.userThreeCaption.isDisplayed());
                break;
            default:
                System.out.println("Invalid User");
        }
    }
}
