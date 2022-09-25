package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.DropDownPage;
import utils.PropertyKeys;

import java.time.Duration;

public class DropDownSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private DropDownPage dropDownPage;

    public DropDownSteps() {
        String timeout = PropertyKeys.getProperty("timeout");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
        dropDownPage = new DropDownPage(driver, wait);
    }

    @Given("user navigates to drop down page")
    public void navigateToDropDownPage() {
        driver.get(PropertyKeys.getProperty("baseurl") + "/dropdown");
        dropDownPage.WaitUntilElementVisible(dropDownPage.dropDownPageHeader);
    }

    @And("^user selects dropdown \"(.*)\"$")
    public void selectDropdownOption(String option) {
        Select select = new Select(dropDownPage.dropDown);
        select.selectByVisibleText(option);
    }

    @Then("^dropdown option \"(.*)\" is selected$")
    public void dropDownOptionSelected(String option) {
        String selectedOptionText = dropDownPage.selectedOption.getText();
        Assert.assertEquals(option, selectedOptionText);
    }
}
