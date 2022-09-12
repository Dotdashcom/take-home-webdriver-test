package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;

import static support.TestSetUp.getDriver;

public class TakeHomeStepDefs {
    private String username = "tomsmith";
    private String validPass = "SuperSecretPassword!";
    private String invalidPass = "SuperPassword";

    private String expectedMes = "You logged into a secure area!";
    private String expectedErrMes = "Your password is invalid!";

    private String expectedAlertText = "You selected a context menu";

    LoginPage loginPage = new LoginPage();
    CheckboxesPage checkboxesPage = new CheckboxesPage();
    ContextMenuPage contextMenuPage = new ContextMenuPage();
    DropdownPage dropdownPage = new DropdownPage();
    DragAndDropPage dragAndDropPage = new DragAndDropPage();
    DynamicContentPage dynamicContentPage = new DynamicContentPage();
    DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();

    @Given("I navigate to {string} page")
    public void iNavigateToPage(String page) {
        if (page.equals("take-home")) {
            getDriver().get("http://localhost:7080");
        } else {
            throw new Error("Unsupported page " + page);
        }
    }

    @When("I fill out required fields with valid creds")
    public void iFillOutRequiredFieldsWithValidCreds() {
        loginPage.open();
        loginPage.filloutFields(username, validPass);
    }

    @When("i fill out required fields with invalid creds")
    public void iFillOutRequiredFieldsWithInvalidCreds() {
        loginPage.open();
        loginPage.filloutFields(username, invalidPass);
    }

    @And("I click login button")
    public void iClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I verify login is successful")
    public void iVerifyLoginIsSuccessful() {
        Assert.assertTrue(loginPage.getMes().contains(expectedMes));
    }

    @Then("I verify login is not successful")
    public void iVerifyLoginIsNotSuccessful() {
        Assert.assertTrue(loginPage.getMes().contains(expectedErrMes));
    }

    @When("I {string} all checkboxes")
    public void iAllCheckboxes(String state) {
        checkboxesPage.open();
        if (state.equals("select")) {
            checkboxesPage.selectAllCheckboxes();
        } else {
            checkboxesPage.unselectAllCheckboxes();
        }
    }

    @Then("I verify all checkboxes are selected")
    public void iVerifyAllCheckboxesAreSelected() {
        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked());
    }

    @Then("I verify all checkboxes are unselected")
    public void iVerifyAllCheckboxesAreUnselected() {
        Assert.assertTrue(!checkboxesPage.areAllCheckboxesChecked());
    }

    @When("I right-click context menu")
    public void iRightClickContextMenu() {
        contextMenuPage.open();
        contextMenuPage.rightClick();
    }

    @Then("I verify JavaScript alert is triggered")
    public void iVerifyJavaScriptAlertIsTriggered() {
        Assert.assertTrue(contextMenuPage.getAlertText().contains(expectedAlertText));
    }

    @When("I select {string} from the dropdown menu")
    public void iSelectFromTheDropdownMenu(String option) {
        dropdownPage.open();
        dropdownPage.selectOption(option);
    }

    @Then("I verify {string} is selected")
    public void iVerifyIsSelected(String option) {
        Assert.assertEquals(dropdownPage.getSelectedOption(), option);
    }

    @When("I drag element A to element B")
    public void iDragElementAToElementB() {
        dragAndDropPage.open();
        dragAndDropPage.dragAndDropElem();
    }

    @Then("I verify that the text on element A and B are switched")
    public void iVerifyThatTheTextOnElementAAndBAreSwitched() {
        Assert.assertEquals(dragAndDropPage.getElemAText(), "B");
        Assert.assertEquals(dragAndDropPage.getElemBText(), "A");
    }

    @When("I refresh the page")
    public void iRefreshThePage() {
        dynamicContentPage.open();
        dynamicContentPage.refreshPage();
    }

    @Then("I verify that content is changed")
    public void iVerifyThatContentIsChanged() {
        String beforeContent = dynamicContentPage.getContent();
        dynamicContentPage.refreshPage();
        Assert.assertTrue(!dynamicContentPage.getContent().equals(beforeContent));
    }

    @When("I click on the Remove Button and use explicit wait")
    public void iClickOnTheRemoveButtonAndUseExplicitWait() {
        dynamicControlsPage.open();
        dynamicControlsPage.clickRemoveOrAddButton();
    }

    @Then("I verify that the checkbox is gone")
    public void iVerifyThatTheCheckboxIsGone() {
        Assert.assertTrue(dynamicControlsPage.isCheckboxDisplayed());
    }

    @When("I click on Add Button and use explicit wait")
    public void iClickOnAddButtonAndUseExplicitWait() {
        dynamicControlsPage.clickRemoveOrAddButton();
    }

    @Then("I verify that the checkbox is present")
    public void iVerifyThatTheCheckboxIsPresent() {
        Assert.assertTrue(!dynamicControlsPage.isCheckboxDisplayed());
    }

    @When("I click on the Enable Button and use explicit wait")
    public void iClickOnTheEnableButtonAndUseExplicitWait() {
        dynamicControlsPage.clickEnableOrDisableButton();
    }

    @Then("I verify that the text box is enabled")
    public void iVerifyThatTheTextBoxIsEnabled() {
        Assert.assertTrue(dynamicControlsPage.isEnabled());
    }

    @When("I click on the Disable Button and use explicit wait")
    public void iClickOnTheDisableButtonAndUseExplicitWait() {
        dynamicControlsPage.clickEnableOrDisableButton();
    }

    @Then("i verify that the text box is disabled")
    public void iVerifyThatTheTextBoxIsDisabled() {

        Assert.assertTrue(!dynamicControlsPage.isEnabled());
    }
}


