package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import PageObjects.DragAndDropPage;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import Utilities.UI_Util;

public class T05_DragAndDropStepDefs {

    DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @Given("user is on {string} page")
    public void user_is_on_page(String endpoint) {
        Driver.getDriver().get(ConfigurationReader.getProperty("BaseUrl") + endpoint);
    }

    @When("user drags element A and drops to element B")
    public void user_drags_element_a_and_drops_to_element_b() throws InterruptedException {

        UI_Util.move_elements(dragAndDropPage.columnA, dragAndDropPage.columnB);
    }

    @Then("user should be abel to assert the text switch on the elements")
    public void user_should_be_abel_to_assert_the_text_switch_on_the_elements() {

        Assert.assertEquals("B", dragAndDropPage.columnAHeader.getText());
        Assert.assertEquals("A", dragAndDropPage.columnBHeader.getText());

    }

}
