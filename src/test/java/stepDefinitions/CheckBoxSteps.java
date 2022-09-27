package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CheckBoxPage;
import utils.PropertyKeys;
import java.time.Duration;
import java.util.List;

public class CheckBoxSteps {
    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private CheckBoxPage checkBoxPage;

    public CheckBoxSteps() throws Exception {
        String timeout = PropertyKeys.getProperty("timeout");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
        checkBoxPage = new CheckBoxPage(driver, wait);
    }

    @Given("user navigates to checkboxes page")
    public void navigateToCheckboxPage() {
        driver.get(PropertyKeys.getProperty("baseurl") + "/checkboxes");
    }

    @When("user checks on all boxes")
    public void checkAllBoxes() {
        List<WebElement> checkboxes = checkBoxPage.checkBoxes;
        for (int i = 0; i < checkboxes.size(); i++) {
            if (!checkboxes.get(i).isSelected()) {
                checkboxes.get(i).click();
            }
        }
    }

    @When("user unchecks all boxes")
    public void uncheckAllBoxes() {
        List<WebElement> checkboxes = checkBoxPage.checkBoxes;
        for (int i = 0; i < checkboxes.size(); i++) {
            if (checkboxes.get(i).isSelected()) {
                checkboxes.get(i).click();
            }
        }
    }

    @Then("all boxes are selected")
    public void validateAllBoxesSelected() throws InterruptedException {
        List<WebElement> checkboxes = checkBoxPage.checkBoxes;
        for (int i = 0; i < checkboxes.size(); i++) {
            Assert.assertTrue(checkboxes.get(i).isSelected());
        }
    }

    @Then("all boxes are not selected")
    public void validateAllBoxesNotSelected() throws InterruptedException {
        List<WebElement> checkboxes = checkBoxPage.checkBoxes;
        for (int i = 0; i < checkboxes.size(); i++) {
            Assert.assertFalse(checkboxes.get(i).isSelected());
        }
    }
}
