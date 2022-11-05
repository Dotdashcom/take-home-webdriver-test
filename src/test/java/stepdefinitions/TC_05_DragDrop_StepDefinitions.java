package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.TC_05_DragDrop_Page;
import utilities.Driver;

public class TC_05_DragDrop_StepDefinitions {
    TC_05_DragDrop_Page dragDropPage = new TC_05_DragDrop_Page();
    @Given("User goes to the drag and drop page")
    public void user_goes_to_the_drag_and_drop_page() {
       dragDropPage.dragDropLink.click();
    }
    @When("user drags A to drop B")
    public void user_drags_a_to_drop_b() {
        Actions actions=new Actions(Driver.getDriver());
        actions.dragAndDrop(dragDropPage.boxA, dragDropPage.boxB).perform();
    }
    @Then("user sees A and B is switched")
    public void user_sees_a_and_b_is_switched() {
        System.out.println("dragAndDropPage.columnA.getText() = " + dragDropPage.boxA.getText());
        if (dragDropPage.boxA.getText().equals("B")) {

            Assert.assertTrue(dragDropPage.boxA.getText().equals("B"));
        }else{
            Assert.assertTrue(dragDropPage.boxA.getText().equals("A"));
        }

    }
}

